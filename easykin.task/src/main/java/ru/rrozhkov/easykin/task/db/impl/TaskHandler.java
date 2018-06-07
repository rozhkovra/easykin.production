package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;
import ru.rrozhkov.lib.util.DateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class TaskHandler extends EntityHandler {
	final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();

	protected String getTableName() {
		return "TASK";
	}

	@Override
	protected IEntityConverter getConverter() {
		return taskConverterFactory.task();
	}

	protected String getSelect() {
		return "SELECT " + getTableName() + ".*, CATEGORY.NAME as CATEGORYNAME FROM " + getTableName()
				+ " INNER JOIN CATEGORY ON " + getTableName() + ".CATEGORYID = CATEGORY.ID"
				+ " ORDER BY " + getTableName() + ".STATUSID, " + getTableName() + ".PRIORITYID, "
				+ getTableName() + ".PLANDATE, " + getTableName() + ".CATEGORYID";
	}

	public String selectTask = "SELECT "+getTableName()+".*, CATEGORY.NAME as CATEGORYNAME FROM "+getTableName()
			+" INNER JOIN CATEGORY ON "+getTableName()+".CATEGORYID = CATEGORY.ID"
			+" WHERE ID=#id#";

	public String selectForPerson = "SELECT "+getTableName()+".*, CATEGORY.NAME as CATEGORYNAME FROM "+getTableName()
			+" INNER JOIN CATEGORY ON "+getTableName()+".CATEGORYID = CATEGORY.ID"
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = "+getTableName()+".ID AND TASK2PERSON.PERSON=#person#"
			+" ORDER BY "+getTableName()+".STATUSID, "+getTableName()+".PRIORITYID, "
			+getTableName()+".PLANDATE, "+getTableName()+".CATEGORYID";

	protected String getInsert() {
		return "INSERT INTO " + getTableName()
				+ "(ID, NAME, CREATEDATE, PLANDATE, PRIORITYID, CATEGORYID, CLOSEDATE, STATUSID)"
				+ " VALUES(#id#,'#name#','#createdate#','#plandate#',#priorityid#,#categoryid#,NULL,#statusid#)";
	}

	protected String getUpdate() {
		return "UPDATE " + getTableName() + " SET NAME='#name#', PLANDATE='#plandate#', PRIORITYID=#priorityid#,"
				+ " CATEGORYID=#categoryid# WHERE ID=#id#";
	}
	
	public String close = "UPDATE "+getTableName()+" SET CLOSEDATE='"+ DateUtil.formatSql(new Date())+"',"
			+ " STATUSID="+Status.status(Status.CLOSE)+" WHERE ID=#id#";

	public Collection<ITask> selectForPerson(int id) throws Exception {
		return dbManager().select(selectForPerson.replace("#person#", String.valueOf(id)), getConverter());
	}

	public Collection<ITask> selectForFilter(TaskFilterBean bean) throws Exception {
		StringBuilder select = new StringBuilder();
		select.append("SELECT ").append(getTableName()).append(".*, CATEGORY.NAME as CATEGORYNAME FROM ").append(getTableName())
				.append(" INNER JOIN CATEGORY ON ").append(getTableName()).append(".CATEGORYID = CATEGORY.ID")
				.append(" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = ").append(getTableName()).append(".ID");
		select.append(" WHERE 1=1");
		if (bean.getStatusId()>0) {
			select.append(" AND ").append(getTableName()).append(".STATUSID = ").append(bean.getStatusId());
		}
		if (bean.getCategoryId()>0) {
			select.append(" AND ").append(getTableName()).append(".CATEGORYID = ").append(bean.getCategoryId());
		}
		if (bean.getPriorityId()>0) {
			select.append(" AND ").append(getTableName()).append(".PRIORITYID = ").append(bean.getPriorityId());
		}
		if (bean.getFromDate()!=null) {
			select.append(" AND ").append(getTableName()).append(".PLANDATE >= '").append(DateUtil.formatSql(bean.getFromDate())).append("'");
		}
		if (bean.getToDate()!=null) {
			select.append(" AND ").append(getTableName()).append(".PLANDATE <= '").append(DateUtil.formatSql(bean.getToDate())).append("'");
		}
		select.append(" ORDER BY ").append(getTableName()).append(".STATUSID, ")
				.append(getTableName()).append(".PRIORITYID, ")
				.append(getTableName()).append(".PLANDATE, ")
				.append(getTableName()).append(".CATEGORYID");

		return dbManager().select(select.toString(), getConverter());
	}

	public ITask selectTask(int taskId) throws Exception {
		Collection<ITask> tasks = dbManager().select(selectTask.replace("#id#", String.valueOf(taskId)), getConverter());
		if(tasks!=null && !tasks.isEmpty())
			return CollectionUtil.get(tasks,0);
		return null;
	}

	public int close(ITask task) throws SQLException{
		try {
			Map<String, Object> map = getConverter().map(task);
			int count = dbManager().update(close, map);
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 
	}
}