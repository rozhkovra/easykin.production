package ru.rrozhkov.easykin.task.comment.impl.filter;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.lib.filter.IFilter;

public class TaskFilter implements IFilter<IComment> {
	private int taskId;
	protected TaskFilter(int taskId) {
		this.taskId = taskId;
	}
	public boolean filter(IComment comment) {
		return taskId == comment.getTaskId();
	}
}
