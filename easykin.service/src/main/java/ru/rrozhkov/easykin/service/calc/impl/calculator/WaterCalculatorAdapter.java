package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterResult;
import ru.rrozhkov.easykin.service.calculator.WaterCalculator;

public class WaterCalculatorAdapter extends Calculator {
	private static final WaterCalculator waterCalculator = new WaterCalculator();

	public WaterCalculatorAdapter(WaterCalc calc) {
		super(calc);
	}

	public WaterResult calculate() {
		WaterCalc calc = (WaterCalc)getCalc();
		Money rateIn = calc.getInRate();
		Money rateOut = calc.getOutRate();
		int currCold = (int)calc.getColdCurrentMeasure()+(int)calc.getColdCurrentMeasure2();
		int prevCold = (int)calc.getColdPrevMeasure()+(int)calc.getColdPrevMeasure2();
		int currHot = (int)calc.getHotCurrentMeasure()+(int)calc.getHotCurrentMeasure2();
		int prevHot = (int)calc.getHotPrevMeasure()+(int)calc.getHotPrevMeasure2();
		double result = waterCalculator.calculate(rateIn.getValue(), rateOut.getValue(), currCold, prevCold, currHot, prevHot);
		Money sum = Money.valueOf(result);
		return new WaterResult(0, Money.valueOf(0.0), 0, Money.valueOf(0.0), sum);
	}
}