package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class PriorityFilter implements IFilter<ITask> {
	private Priority priority;
	protected PriorityFilter(Priority priority) {this.priority = priority;}
	public boolean filter(ITask obj) {
		return priority.equals(obj.getPriority());
	}
}
