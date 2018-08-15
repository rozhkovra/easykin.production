package ru.rrozhkov.easykin.model.service.calc;

import ru.rrozhkov.easykin.core.calculation.ICalculator;

public interface IServiceCalculator extends ICalculator {
	ICalcBean getCalcBean();
	IServiceResult calculate();
}