package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;
import ru.rrozhkov.lib.util.DateUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class TaskHandler {
	final private static IDBManager dbManager = DBManager.instance();
	final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();
	final private static IEntityConverter converter = taskConverterFactory.task();

	private static String TABLENAME = "TASK";

	public static String select = "SELECT "+TABLENAME+".*, CATEGORY.NAME as CATEGORYNAME FROM "+TABLENAME
			+" INNER JOIN CATEGORY ON "+TABLENAME+".CATEGORYID = CATEGORY.ID"
			+" ORDER BY "+TABLENAME+".STATUSID, "+TABLENAME+".PRIORITYID, "+TABLENAME+".PLANDATE, "+TABLENAME+".CATEGORYID";

	public static String selectTask = "SELECT "+TABLENAME+".*, CATEGORY.NAME as CATEGORYNAME FROM "+TABLENAME
			+" INNER JOIN CATEGORY ON "+TABLENAME+".CATEGORYID = CATEGORY.ID"
			+" WHERE ID=#id#";

	public static String selectForPerson = "SELECT "+TABLENAME+".*, CATEGORY.NAME as CATEGORYNAME FROM "+TABLENAME
			+" INNER JOIN CATEGORY ON "+TABLENAME+".CATEGORYID = CATEGORY.ID"
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = "+TABLENAME+".ID AND TASK2PERSON.PERSON=#person#"
			+" ORDER BY "+TABLENAME+".STATUSID, "+TABLENAME+".PRIORITYID, "+TABLENAME+".PLANDATE, "+TABLENAME+".CATEGORYID";
	
	public static String insert = "INSERT INTO "+TABLENAME
			+"(ID, NAME, CREATEDATE, PLANDATE, PRIORITYID, CATEGORYID, CLOSEDATE, STATUSID)"
			+" VALUES(#id#,'#name#','#createdate#','#plandate#',#priorityid#,#categoryid#,NULL,#statusid#)";
	
	public static String update = "UPDATE "+TABLENAME+" SET NAME='#name#', PLANDATE='#plandate#', PRIORITYID=#priorityid#,"
			+" CATEGORYID=#categoryid# WHERE ID=#id#";
	
	public static String close = "UPDATE "+TABLENAME+" SET CLOSEDATE='"+ DateUtil.formatSql(new Date())+"',"
			+ " STATUSID="+Status.status(Status.CLOSE)+" WHERE ID=#id#";


	public Collection<ITask> select() throws Exception{
		return dbManager.select(select, converter);
	}

	public Collection<ITask> selectForPerson(int id) throws Exception {
		return dbManager.select(selectForPerson.replace("#person#", String.valueOf(id)), converter);
	}

	public Collection<ITask> selectForFilter(TaskFilterBean bean) throws Exception {
		StringBuilder select = new StringBuilder();
		select.append("SELECT ").append(TABLENAME).append(".*, CATEGORY.NAME as CATEGORYNAME FROM ").append(TABLENAME)
				.append(" INNER JOIN CATEGORY ON ").append(TABLENAME).append(".CATEGORYID = CATEGORY.ID")
				.append(" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = ").append(TABLENAME).append(".ID");
		select.append(" WHERE 1=1");
		if (bean.getStatusId()>0) {
			select.append(" AND ").append(TABLENAME).append(".STATUSID = ").append(bean.getStatusId());
		}
		if (bean.getCategoryId()>0) {
			select.append(" AND ").append(TABLENAME).append(".CATEGORYID = ").append(bean.getCategoryId());
		}
		if (bean.getPriorityId()>0) {
			select.append(" AND ").append(TABLENAME).append(".PRIORITYID = ").append(bean.getPriorityId());
		}
		if (bean.getFromDate()!=null) {
			select.append(" AND ").append(TABLENAME).append(".PLANDATE >= '").append(DateUtil.formatSql(bean.getFromDate())).append("'");
		}
		if (bean.getToDate()!=null) {
			select.append(" AND ").append(TABLENAME).append(".PLANDATE <= '").append(DateUtil.formatSql(bean.getToDate())).append("'");
		}
		select.append(" ORDER BY ").append(TABLENAME).append(".STATUSID, ")
				.append(TABLENAME).append(".PRIORITYID, ")
				.append(TABLENAME).append(".PLANDATE, ")
				.append(TABLENAME).append(".CATEGORYID");

		return dbManager.select(select.toString(), converter);
	}

	public ITask selectTask(int taskId) throws Exception {
		Collection<ITask> tasks = dbManager.select(selectTask.replace("#id#", String.valueOf(taskId)), converter);
		if(tasks!=null && !tasks.isEmpty())
			return CollectionUtil.get(tasks,0);
		return null;
	}
	
	public int insert(ITask task) throws SQLException{
		try {
			Map<String, Object> map = converter.map(task);
			int id = dbManager.nextId(TABLENAME);
			map.put("id", id);
			dbManager.insert(insert, map);
			return id;
		} catch (Exception e) { 
			throw new SQLException(e); 
		}
	}
	
	public int update(ITask task) throws SQLException{
		try {
			Map<String, Object> map = converter.map(task);
			int count = dbManager.update(update, map);
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 
	}

	public int close(ITask task) throws SQLException{
		try {
			Map<String, Object> map = converter.map(task);
			int count = dbManager.update(close, map);
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 
	}
}