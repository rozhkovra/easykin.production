package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.impl.convert.CommentMapConverter;
import ru.rrozhkov.easykin.task.impl.convert.DBCommentConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class CommentHandler {
	private static String TABLENAME = "COMMENT";
	
	public static String select = "SELECT * FROM "+TABLENAME;
	public static String selectForTask = "SELECT * FROM "+TABLENAME+" where taskId=#taskId#";
	public static String selectForPerson = "SELECT * FROM "+TABLENAME
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = COMMENT.TASKID AND TASK2PERSON.PERSON=#person#";
	public static String insert = "INSERT INTO "+TABLENAME
			+"(ID, TEXT, CREATEDATE, TASKID)"
			+" VALUES(#id#,'#text#','#createdate#',#taskid#)";
	public static String update = "UPDATE "+TABLENAME+" SET TEXT='#text#', CREATEDATE='#createdate#', TASKID=#taskid#"
			+" WHERE ID=#id#";



	public static Collection<IComment> select() throws Exception {
		return DBManager.instance().select(select, new DBCommentConverter());
	}
	
	public static Collection<IComment> selectForTask(int taskId) throws Exception {
		return DBManager.instance().select(selectForTask.replace("#taskId#", String.valueOf(taskId)), new DBCommentConverter());
	}
	
	public static Collection<IComment> selectForPerson(int personId) throws Exception {
		return DBManager.instance().select(selectForPerson.replace("#person#", String.valueOf(personId)), new DBCommentConverter());
	}

	public static int insert(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = new CommentMapConverter().convert(comment);
			int id = DBManager.instance().nextId(TABLENAME);
			map.put("id", id);
			DBManager.instance().insert(insert,map);
			return id;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static int update(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = new CommentMapConverter().convert(comment);
			int count = DBManager.instance().update(update, map);
			return count;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}