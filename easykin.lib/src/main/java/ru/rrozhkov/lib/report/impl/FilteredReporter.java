package ru.rrozhkov.lib.report.impl;

import java.util.Collection;

import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.report.IReporter;

public abstract class FilteredReporter implements IReporter {
	protected Collection<IFilter> filters = null;

	public void setFilter(Collection<IFilter> filters) {
		this.filters = filters;
	}

	public Collection<IFilter> getFilters() {
		return filters;
	}
}