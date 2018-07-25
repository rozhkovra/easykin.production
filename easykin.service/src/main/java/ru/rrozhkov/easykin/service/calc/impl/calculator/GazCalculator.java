package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazResult;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

public class GazCalculator extends Calculator {
	private static final MeasureCalculator measureCalculator = new MeasureCalculator();

	public GazCalculator(ICalculation gaz) {
		super(gaz);
	}

	public GazResult calculate() {
		GazCalc calcBean = (GazCalc)getCalc();
		int currMeasure = (int)calcBean.getCurrentMeasure();
		int prevMeasure = (int)calcBean.getPrevMeasure();
		double rate = calcBean.getRate().getValue();
		Money sum = Money.valueOf(measureCalculator.calculate(currMeasure, prevMeasure, rate));
		double delta = calcBean.getCurrentMeasure() - calcBean.getPrevMeasure();
		return new GazResult(delta, sum);
	}
}