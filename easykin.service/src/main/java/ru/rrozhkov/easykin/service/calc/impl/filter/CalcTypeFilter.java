package ru.rrozhkov.easykin.service.calc.impl.filter;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class CalcTypeFilter implements IFilter<ICalculation> {
	private CalculationType type;
	
	protected CalcTypeFilter(CalculationType type) {
		this.type = type;
	}

	public boolean filter(ICalculation obj) {
		return type.equals(obj.getType());
	}
}