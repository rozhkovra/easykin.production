package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterResult;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

public class HotWaterCalculator extends Calculator {
	private static final MeasureCalculator measureCalculator = new MeasureCalculator();

	public HotWaterCalculator(ICalculation calc) {
		super(calc);
	}

	public HotWaterResult calculate() {
		HotWaterCalc calc = (HotWaterCalc)getCalc();
		int currHot = (int)calc.getCurrentMeasure() + (int)calc.getCurrentMeasure2();
		int prevHot = (int)calc.getPrevMeasure() + (int)calc.getPrevMeasure2();
		double rate = calc.getRate().getValue();
		Money sum = Money.valueOf(measureCalculator.calculate(currHot, prevHot, rate));
		double hotDelta = (calc.getCurrentMeasure()+calc.getCurrentMeasure2())-(calc.getPrevMeasure()+calc.getPrevMeasure2());
		return new HotWaterResult(hotDelta, sum, sum);
	}
}