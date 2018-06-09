package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class OnlyWorkFilter implements IFilter<ITask> {
	protected OnlyWorkFilter() {}
	public boolean filter(ITask obj) {
		return ((Category)obj.getCategory()).isWork();
	}
}