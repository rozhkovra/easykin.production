package ru.rrozhkov.easykin.model.service.calc.impl.filter;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.lib.filter.IFilter;

public class ServiceCalcFilterFactory {
	public static IFilter<ICalculation> createCalcTypeFilter(CalculationType type){
		return new CalcTypeFilter(type);
	}
}