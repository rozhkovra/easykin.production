package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.lib.filter.IFilter;

public class PriorityFilter implements IFilter<ITask> {
	private Priority priority;
	
	public PriorityFilter(Priority priority) {
		this.priority = priority;
	}

	public boolean filter(ITask obj) {
		return priority.equals(obj.getPriority());
	}
}
