package ru.rrozhkov.easykin.model.task.comment.impl.filter;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.lib.filter.IFilter;

public class TaskFilter implements IFilter<IComment> {
	private int taskId;
	
	public TaskFilter(int taskId) {
		this.taskId = taskId;
	}

	public boolean filter(IComment comment) {
		return taskId == comment.getTaskId();
	}

}
