package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

import java.util.Collection;

public class CommentHandler extends EntityHandler {
	final private static TaskConverterFactory converterFactory = TaskConverterFactory.instance();
	final private String selectForTask = "SELECT * FROM "+getTableName()+" where taskId=#taskId#";
	final private String selectForPerson = "SELECT * FROM "+getTableName()
			+" INNER JOIN TASK2PERSON ON TASK2PERSON.TASK = COMMENT.TASKID AND TASK2PERSON.PERSON=#person#";

	public static class CommentHandlerHolder {
		public static final CommentHandler INSTANCE = new CommentHandler();
	}

	public static CommentHandler instance(){
		return CommentHandlerHolder.INSTANCE;
	}

	private CommentHandler() {
	}

	protected String getTableName() { return  "COMMENT";}

	protected String getInsert() {
		return "INSERT INTO "+getTableName()
				+"(ID, TEXT, CREATEDATE, TASKID)"
				+" VALUES(#id#,'#text#','#createdate#',#taskid#)";
	}
	protected String getUpdate() {
		return "UPDATE " + getTableName() + " SET TEXT='#text#', CREATEDATE='#createdate#', TASKID=#taskid#"
				+ " WHERE ID=#id#";
	}
	protected IEntityConverter getConverter() {
		return converterFactory.comment();
	}

	public Collection<IComment> selectForTask(int taskId) throws Exception {
		return dbManager().select(selectForTask.replace("#taskId#", String.valueOf(taskId)), getConverter());
	}
	
	public Collection<IComment> selectForPerson(int personId) throws Exception {
		return dbManager().select(selectForPerson.replace("#person#", String.valueOf(personId)), getConverter());
	}
}