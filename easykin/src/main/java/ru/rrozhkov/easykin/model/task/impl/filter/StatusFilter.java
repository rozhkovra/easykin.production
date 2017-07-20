package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.filter.IFilter;

public class StatusFilter implements IFilter<ITask> {
	private Status status;
	
	public StatusFilter(Status status) {
		this.status = status;
	}

	public boolean filter(ITask obj) {
		return status.equals(obj.getStatus());
	}
}