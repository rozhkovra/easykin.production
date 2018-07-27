package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

public class CalculatorFactory extends CalculatorAbstractFactory {
	protected CalculatorFactory() {
	}

	public ICalculator getCalculator(ICalculation bean){
		if (bean instanceof Calculation) {

		}
		return AbstractServiceFactory.instance(bean.getClass()).getCalculator(bean);
	}
}