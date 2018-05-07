package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.util.TaskUtil;
import ru.rrozhkov.lib.filter.IFilter;

public class WithPaymentFilter implements IFilter<ITask> {
	protected WithPaymentFilter() {}
	public boolean filter(ITask task) {
		return TaskUtil.withPayment(task);
	}
}