package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureResult;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

public class MeasureCalculatorAdapter extends Calculator {
	private static final MeasureCalculator measureCalculator = new MeasureCalculator();

	public MeasureCalculatorAdapter(ICalculation bean) {
		super(bean);
	}

	public MeasureResult calculate() {
		MeasureCalc calcBean = (MeasureCalc)getCalc();
		int currMeasure = calcBean.getCurrentMeasure();
		int prevMeasure = calcBean.getPrevMeasure();
		double rate = calcBean.getRate().getValue();
		double delta = calcBean.getCurrentMeasure() - calcBean.getPrevMeasure();
		Money sum = Money.valueOf(measureCalculator.calculate(currMeasure, prevMeasure, rate));
		return new MeasureResult(delta, sum);
	}
}