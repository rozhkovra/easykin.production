package ru.rrozhkov.easykin.work.db.impl;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.impl.convert.WorkConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class ActivityHandler {
	private static final IDBManager dbManager = DBManager.instance();
	private static final WorkConverterFactory converterFactory = new WorkConverterFactory();
	private static final IEntityConverter converter = converterFactory.activity();

	private static String TABLENAME = "ACTIVITY";

	public static String select = "select * from "+TABLENAME;

	public static String insert = "INSERT INTO "+TABLENAME
			+"(ID, ACTDATE, PERSONID, ACTTIME, TASKTYPE, NAME, RELEASETYPE, DESC)"
			+" VALUES(#id#,'#date#',#personId#,#time#,'#taskType#','#name#','#releaseType#','#desc#')";

	public static String selectForPerson = "select * from "+TABLENAME
			+" WHERE PERSONID=#person#"
			+" ORDER BY "+TABLENAME+".ACTDATE desc";

	public static String update = "UPDATE "+TABLENAME+" SET ACTDATE='#date#', PERSONID=#personId#, ACTTIME=#time#,"
			+" TASKTYPE='#taskType#', NAME='#name#', RELEASETYPE='#releaseType#', DESC='#desc#' WHERE ID=#id#";


	public static Collection<IActivity> select() throws Exception {
		return dbManager.select(select, converter);
	}

	public static Collection<IActivity> selectForPerson(int id) throws Exception {
		return dbManager.select(selectForPerson.replace("#person#", String.valueOf(id)), converter);
	}

	public static int insert(IActivity activity) throws SQLException {
		try {
			Map<String, Object> map = converter.map(activity);
			int id = dbManager.nextId(TABLENAME);
			map.put("id", id);
			dbManager.insert(insert, map);
			return id;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static int update(IActivity activity) throws SQLException{
		try {
			Map<String, Object> map = converter.map(activity);
			int count = dbManager.update(update, map);
			return count;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}
