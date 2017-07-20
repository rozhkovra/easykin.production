package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.category.Category;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.filter.IFilter;

public class OnlyHomeFilter implements IFilter<ITask> {
	public boolean filter(ITask obj) {
		return ((Category)obj.getCategory()).isHome();
	}
}