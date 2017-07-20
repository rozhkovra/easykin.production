package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.filter.IFilter;

public class NoFreeFilter implements IFilter<IService> {
	public boolean filter(IService obj) {
		return !obj.getPrice().free();
	}
}