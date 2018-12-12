package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.*;

import java.util.Date;

public class TaskFactory{
	private static class Holder {
		private static final TaskFactory INSTANCE = new TaskFactory();
	}

	public static TaskFactory instance(){
		return Holder.INSTANCE;
	}

	private TaskFactory() {
	}

	public ITask createTask(int id, String name, Date createDate, Date plannedDate,
								   int priority, int categoryId, String categoryName, Date closeDate, int status) {
		return new Task(id, name, createDate, plannedDate, Priority.priority(priority)
				, new Category(categoryId,categoryName), closeDate, Status.status(status));
	}

	public ITask createTask(int id, String name, Date createDate, Date plannedDate,
								   Priority priority, ICategory category,  Date closeDate, Status status) {
		return new Task(id, name, createDate, plannedDate, priority, category, closeDate, status);
	}

	public ITask newTask(){
		return createTask(-1, "", new Date(), new Date(), Priority.priority(Priority.SIMPLE)
				, 1, "", null, Status.status(Status.OPEN));
	}

	public IComment createComment(int id, String text, Date date, int taskId) {
		return new Comment(id, text, date, taskId);
	}
	public IComment newComment(int taskId) {
		return new Comment(-1, "", new Date(), taskId);
	}
	public ITask2Person createTask2Person(int id, int personId, int taskId) {
		return new Task2Person(id, personId, taskId);
	}
	public ITask2Payment createTask2Payment(int id, int paymentId, int taskId) {
		return new Task2Payment(id, paymentId, taskId);
	}
}