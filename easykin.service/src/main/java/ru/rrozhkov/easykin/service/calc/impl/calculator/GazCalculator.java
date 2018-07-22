package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazResult;

public class GazCalculator extends Calculator {
	public GazCalculator(GazCalc gaz) {
		super(gaz);
	}

	public GazResult calculate() {
		GazCalc calcBean = (GazCalc)getCalc(); 
		double delta = calcBean.getCurrentMeasure()-calcBean.getPrevMeasure();
		return  new GazResult(delta, MoneyFactory.create(calcBean.getRate()).multiply(delta));
	}
}