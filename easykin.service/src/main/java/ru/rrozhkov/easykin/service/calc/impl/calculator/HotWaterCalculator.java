package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterResult;

public class HotWaterCalculator extends Calculator {
	public HotWaterCalculator(HotWaterCalc calc) {
		super(calc);
	}

	public HotWaterResult calculate() {
		HotWaterCalc calc = (HotWaterCalc)getCalc();
		double hotDelta = (calc.getCurrentMeasure()+calc.getCurrentMeasure2())-(calc.getPrevMeasure()+calc.getPrevMeasure2());
		Money hotSum = MoneyFactory.create(calc.getRate()).multiply(hotDelta);
		return new HotWaterResult(hotDelta, hotSum, hotSum);
	}
}