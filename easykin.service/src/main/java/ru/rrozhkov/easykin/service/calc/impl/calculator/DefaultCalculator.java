package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;


public class DefaultCalculator extends Calculator {
	protected DefaultCalculator(DefaultCalc calcBean) {
		super(calcBean);
	}

	public DefaultResult calculate() {
		DefaultCalc calcBean = (DefaultCalc)getCalc();
		return new DefaultResult(calcBean.getPrice());
	}
}