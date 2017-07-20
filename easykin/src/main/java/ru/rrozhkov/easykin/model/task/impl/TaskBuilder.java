package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.db.impl.CommentHandler;
import ru.rrozhkov.easykin.db.impl.TaskHandler;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.comment.impl.filter.CommentFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class TaskBuilder {
	@Deprecated
	public static ITask build(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, String categoryName, Date closeDate, int status){
		ITask task = TaskFactory.createTask(id, name, createDate, plannedDate, priority, categoryId, categoryName, closeDate, status);		 
		try {
			Collection<IComment> comments = CommentHandler.selectForTask(id);
			task.comments().clear();
			task.comments().addAll(comments);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return task;
	}

	public static ITask buildTask(int id){
		try {
			ITask task = TaskHandler.selectTask(id);
			Collection<IComment> comments = CommentHandler.selectForTask(id);
			task.comments().clear();
			task.comments().addAll(comments);
			return task;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Collection<ITask> build(){
		try {
			Collection<ITask> tasks = TaskHandler.select();
			Collection<IComment> comments = CommentHandler.select();
			for(ITask task : tasks){
				task.comments().clear();
				task.comments().addAll(FilterUtil.filter(comments,CommentFilterFactory.createTaskFilter(task.getId())));
			}
			return tasks;
		} catch (SQLException e) {
			e.printStackTrace();
			return CollectionUtil.<ITask>create();
		}
	}	
	
	public static Collection<ITask> build(int personId){
		try {
			Collection<ITask> tasks = TaskHandler.selectForPerson(personId);
			Collection<IComment> comments = CommentHandler.selectForPerson(personId);
			for(ITask task : tasks){
				task.comments().clear();
				task.comments().addAll(FilterUtil.filter(comments,CommentFilterFactory.createTaskFilter(task.getId())));
			}
			return tasks;
		} catch (SQLException e) {
			e.printStackTrace();
			return CollectionUtil.<ITask>create();
		}
	}
}
