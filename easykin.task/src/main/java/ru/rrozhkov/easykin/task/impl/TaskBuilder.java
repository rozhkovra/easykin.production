package ru.rrozhkov.easykin.task.impl;

import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.easykin.task.db.impl.CommentHandler;
import ru.rrozhkov.easykin.task.db.impl.TaskHandler;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.task.comment.impl.filter.CommentFilterFactory;
import ru.rrozhkov.easykin.task.impl.filter.TaskFilterBean;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;
import java.util.Date;

public class TaskBuilder {
	final private static CommentHandler commentHandler = new CommentHandler();
	final private static CommentFilterFactory commentFilterFactory = new CommentFilterFactory();
	final private static TaskHandler taskHandler = new TaskHandler();
	final private static TaskFactory taskFactory = new TaskFactory();

	@Deprecated
	public ITask build(int id, String name, Date createDate, Date plannedDate,
			int priority, int categoryId, String categoryName, Date closeDate, int status){
		ITask task = taskFactory.createTask(id, name, createDate, plannedDate,
				priority, categoryId, categoryName, closeDate, status);
		try {
			Collection<IComment> comments = commentHandler.selectForTask(id);
			task.comments().clear();
			task.comments().addAll(comments);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}

	public ITask buildTask(int id){
		try {
			ITask task = taskHandler.selectTask(id);
			Collection<IComment> comments = commentHandler.selectForTask(id);
			task.comments().clear();
			task.comments().addAll(comments);
			return task;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Collection<ITask> build(){
		try {
			Collection<ITask> tasks = taskHandler.select();
			Collection<IComment> comments = commentHandler.select();
			return build(tasks, comments);
		} catch (Exception e) {
			e.printStackTrace();
			return CollectionUtil.<ITask>create();
		}
	}	
	
	public Collection<ITask> build(int personId){
		try {
			Collection<ITask> tasks = taskHandler.selectForPerson(personId);
			Collection<IComment> comments = commentHandler.selectForPerson(personId);
			return build(tasks, comments);
		} catch (Exception e) {
			e.printStackTrace();
			return CollectionUtil.<ITask>create();
		}
	}

	public Collection<ITask> build(TaskFilterBean bean){
		try {
			Collection<ITask> tasks = taskHandler.selectForFilter(bean);
			Collection<IComment> comments = commentHandler.selectForPerson(bean.getPersonId());
			return build(tasks, comments);
		} catch (Exception e) {
			e.printStackTrace();
			return CollectionUtil.<ITask>create();
		}
	}


	public Collection<ITask> build(Collection<ITask> tasks, Collection<IComment> comments) {
		for(ITask task : tasks){
			task.comments().clear();
			task.comments().addAll(FilterUtil.filter(comments,commentFilterFactory.task(task.getId())));
		}
		return tasks;
	}
}
