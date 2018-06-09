package ru.rrozhkov.easykin.core.report.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.report.IReporter;

public abstract class FilteredReporter implements IReporter {
	protected Collection<IFilter> filters = null;

	public void setFilter(Collection<IFilter> filters) {
		this.filters = filters;
	}

	public Collection<IFilter> getFilters() {
		return filters;
	}
}