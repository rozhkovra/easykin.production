package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterResult;
import ru.rrozhkov.easykin.service.calculator.WaterCalculator;

public class WaterCalculatorAdapter extends Calculator {
	private static final WaterCalculator waterCalculator = new WaterCalculator();

	public WaterCalculatorAdapter(ICalculation calc) {
		super(calc);
	}

	public WaterResult calculate() {
		WaterCalc calc = (WaterCalc)getCalc();
		Money rateIn = calc.getInRate();
		Money rateOut = calc.getOutRate();
		int currCold = calc.getColdCurrentMeasure();
		int prevCold = calc.getColdPrevMeasure();
		int currHot = calc.getHotCurrentMeasure();
		int prevHot = calc.getHotPrevMeasure();
		double result = waterCalculator.calculate(rateIn.getValue(), rateOut.getValue(), currCold, prevCold, currHot, prevHot);
		Money sum = Money.valueOf(result);
		return new WaterResult(0, Money.valueOf(0.0), 0, Money.valueOf(0.0), sum);
	}
}