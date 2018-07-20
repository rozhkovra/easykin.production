package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;


public class DefaultCalculator extends Calculator {
	protected DefaultCalculator(ICalculation calcBean) {
		super(calcBean);
	}

	public DefaultResult calculate() {
		return new DefaultResult(getCalc().getAmount());
	}
}