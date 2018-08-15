package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceCalculator;

public abstract class ServiceCalculator implements IServiceCalculator {
	protected ICalcBean bean;
	public ServiceCalculator(ICalcBean bean) {this.bean = bean;}
	public ICalcBean getCalcBean(){return bean;}
}