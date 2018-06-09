package ru.rrozhkov.easykin.auto.service.impl.filter;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class NoFreeFilter implements IFilter<IService> {
	public boolean filter(IService obj) {
		return !obj.getPrice().free();
	}
}