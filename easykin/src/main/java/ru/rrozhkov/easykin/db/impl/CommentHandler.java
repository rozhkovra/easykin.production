package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.convert.CommentMapConverter;
import ru.rrozhkov.easykin.model.task.impl.convert.DBCommentConverter;

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



	public static Collection<IComment> select() throws SQLException{
		return EasyKinDBManager.instance().select(select, new DBCommentConverter());
	}
	
	public static Collection<IComment> selectForTask(int taskId) throws SQLException{
		return EasyKinDBManager.instance().select(selectForTask.replace("#taskId#", String.valueOf(taskId)), new DBCommentConverter());
	}
	
	public static Collection<IComment> selectForPerson(int personId) throws SQLException{
		return EasyKinDBManager.instance().select(selectForPerson.replace("#person#", String.valueOf(personId)), new DBCommentConverter());
	}

	public static int insert(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = new CommentMapConverter().convert(comment);
			int id = EasyKinDBManager.instance().nextId(TABLENAME);
			map.put("id", id);
			EasyKinDBManager.instance().insert(insert,map);
			return id;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}

	public static int update(IComment comment) throws SQLException{
		try {
			Map<String, Object> map = new CommentMapConverter().convert(comment);
			int count = EasyKinDBManager.instance().update(update, map);
			return count;
		} catch (Exception e) {
			throw new SQLException(e);
		}
	}
}