package ru.rrozhkov.easykin.work.db.impl;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.impl.convert.WorkConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

import java.util.Collection;

public class ActivityHandler extends EntityHandler {
	private static final WorkConverterFactory converterFactory = WorkConverterFactory.instance();

	private String selectForPerson = "select * from "+getTableName()
			+" WHERE PERSONID=#person#"
			+" ORDER BY "+getTableName()+".ACTDATE desc";


	public static class Holder {
		public static final ActivityHandler INSTANCE = new ActivityHandler();
	}

	public static ActivityHandler instance(){
		return Holder.INSTANCE;
	}

	private ActivityHandler() {
	}

	protected String getTableName() {
		return "ACTIVITY";
	}

	protected IEntityConverter getConverter() {
		return converterFactory.activity();
	}

	protected String getInsert() {
		return "INSERT INTO "+getTableName()
				+"(ID, ACTDATE, PERSONID, ACTTIME, TASKTYPE, NAME, RELEASETYPE, DESC)"
				+" VALUES(#id#,'#date#',#personId#,#time#,'#taskType#','#name#','#releaseType#','#desc#')";
	}

	protected String getUpdate() {
		return "UPDATE " + getTableName() + " SET ACTDATE='#date#', PERSONID=#personId#, ACTTIME=#time#,"
				+ " TASKTYPE='#taskType#', NAME='#name#', RELEASETYPE='#releaseType#', DESC='#desc#' WHERE ID=#id#";
	}

	public Collection<IActivity> selectForPerson(final int id) throws Exception {
		return dbManager().select(selectForPerson.replace("#person#", String.valueOf(id)), getConverter());
	}
}
