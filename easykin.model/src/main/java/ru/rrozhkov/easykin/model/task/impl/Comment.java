package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.model.task.IComment;

import java.util.Date;

public class Comment implements IComment {
	protected int id;
	protected String text;
	protected Date date;
	protected int taskId;
	
	public Comment(int id, String text, Date date, int taskId) {
		this.id = id;
		this.text = text;
		this.date = date;
		this.taskId = taskId;
	}

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public Date getDate() {
		return date;
	}

	public int getTaskId() {
		return taskId;
	}
}