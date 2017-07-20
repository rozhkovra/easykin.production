package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.filter.IFilter;

public class CategoryFilter implements IFilter<ITask> {
	private ICategory category;
	public CategoryFilter(ICategory category) {
		this.category = category;
	}

	public boolean filter(ITask task) {
		return this.category.getId()==task.getCategory().getId();
	}
}