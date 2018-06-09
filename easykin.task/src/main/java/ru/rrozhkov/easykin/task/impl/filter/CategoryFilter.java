package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class CategoryFilter implements IFilter<ITask> {
	private ICategory category;
	protected CategoryFilter(ICategory category) {
		this.category = category;
	}
	public boolean filter(ITask task) {
		return this.category.getId()==task.getCategory().getId();
	}
}