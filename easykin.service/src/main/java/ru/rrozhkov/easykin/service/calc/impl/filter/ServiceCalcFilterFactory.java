package ru.rrozhkov.easykin.service.calc.impl.filter;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.lib.filter.IFilter;

public class ServiceCalcFilterFactory {
	public IFilter<ICalculation> createCalcTypeFilter(CalculationType type){
		return new CalcTypeFilter(type);
	}
}