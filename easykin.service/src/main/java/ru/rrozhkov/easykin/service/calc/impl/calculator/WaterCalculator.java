package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterResult;

public class WaterCalculator extends Calculator {
	public WaterCalculator(WaterCalc calc) {
		super(calc);
	}

	public WaterResult calculate() {
		WaterCalc calc = (WaterCalc)getCalc();
		double coldDelta = (calc.getColdCurrentMeasure()+calc.getColdCurrentMeasure2())-(calc.getColdPrevMeasure()+calc.getColdPrevMeasure2());
		Money coldSum = MoneyFactory.create(calc.getInRate()).add(calc.getOutRate()).multiply(coldDelta);
		double hotDelta = (calc.getHotCurrentMeasure()+calc.getHotCurrentMeasure2())-(calc.getHotPrevMeasure()+calc.getHotPrevMeasure2());
		Money hotSum = MoneyFactory.create(calc.getOutRate()).multiply(hotDelta);
		Money sum = coldSum.add(hotSum);
		return new WaterResult(coldDelta, coldSum, hotDelta, hotSum, sum);
	}
}