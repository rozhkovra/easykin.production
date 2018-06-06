package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class CommentHandler {
	final private static TaskConverterFactory converterFactory = new TaskConverterFactory();
	final private static IEntityConverter converter = converterFactory.comment();
	final private static IDBManager dbManager = DBManager.instance();

	final private static String TABLENAME = "COMMENT";
	final private static String select = "SELECT * FROM "+TABLENAME;
	final private static String selectForTask = "SELECT * FROM "+TABLENAME+" where taskId=#taskId#";
	final private static String selectForPerson = "SELECT * FROM "+TABLENAME
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = COMMENT.TASKID AND TASK2PERSON.PERSON=#person#";
	final private static String insert = "INSERT INTO "+TABLENAME
			+"(ID, TEXT, CREATEDATE, TASKID)"
			+" VALUES(#id#,'#text#','#createdate#',#taskid#)";
	final private static String update = "UPDATE "+TABLENAME+" SET TEXT='#text#', CREATEDATE='#createdate#', TASKID=#taskid#"
			+" WHERE ID=#id#";

	public Collection<IComment> select() throws Exception {
		return dbManager.select(select, converter);
	}
	
	public Collection<IComment> selectForTask(int taskId) throws Exception {
		return dbManager.select(selectForTask.replace("#taskId#", String.valueOf(taskId)), converter);
	}
	
	public Collection<IComment> selectForPerson(int personId) throws Exception {
		return dbManager.select(selectForPerson.replace("#person#", String.valueOf(personId)), converter);
	}

	public int insert(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = converter.map(comment);
			int id = dbManager.nextId(TABLENAME);
			map.put("id", id);
			dbManager.insert(insert, map);
			return id;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public int update(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = converter.map(comment);
			int count = dbManager.update(update, map);
			return count;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}