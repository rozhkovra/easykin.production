package ru.rrozhkov.easykin.db.impl;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.model.task.impl.convert.DBTaskConverter;
import ru.rrozhkov.easykin.model.task.impl.convert.TaskMapConverter;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.util.DateUtil;

public class TaskHandler {
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


	public static Collection<ITask> select() throws SQLException{
		return EasyKinDBManager.instance().select(select, new DBTaskConverter());
	}

	public static Collection<ITask> selectForPerson(int id) throws SQLException{
		return EasyKinDBManager.instance().select(selectForPerson.replace("#person#", String.valueOf(id)), new DBTaskConverter());
	}

	public static ITask selectTask(int taskId) throws SQLException{
		Collection<ITask> tasks = EasyKinDBManager.instance().select(selectTask.replace("#id#", String.valueOf(taskId)), new DBTaskConverter());
		if(tasks!=null && !tasks.isEmpty())
			return CollectionUtil.get(tasks,0);
		return null;
	}
	
	public static int insert(ITask task) throws SQLException{
		try {
			Map<String, Object> map = new TaskMapConverter().convert(task);
			int id = EasyKinDBManager.instance().nextId(TABLENAME);
			map.put("id", id);
			EasyKinDBManager.instance().insert(insert,map);
			return id;
		} catch (Exception e) { 
			throw new SQLException(e); 
		}
	}
	
	public static int update(ITask task) throws SQLException{
		try {
			Map<String, Object> map = new TaskMapConverter().convert(task);
			int count = EasyKinDBManager.instance().update(update, map);
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 
	}

	public static int close(ITask task) throws SQLException{
		try {
			Map<String, Object> map = new TaskMapConverter().convert(task);
			int count = EasyKinDBManager.instance().update(close, map);
			return count;
		} catch (Exception e) { 
			throw new SQLException(e); 
		} 
	}
}