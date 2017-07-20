package ru.rrozhkov.easykin.model.service.calc.impl.water;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;

public class WaterCalculator extends Calculator {
	public WaterCalculator(WaterCalc calc) {
		super(calc);
	}

	public WaterResult calculate() {
		WaterCalc calc = (WaterCalc)getCalc();
		double coldDelta = calc.getColdCurrentMesure()-calc.getColdPrevMesure();
		Money coldSum = MoneyFactory.create(calc.getInRate()).add(calc.getOutRate()).multiply(coldDelta);
		double hotDelta = calc.getHotCurrentMesure()-calc.getHotPrevMesure();
		Money hotSum = MoneyFactory.create(calc.getOutRate()).multiply(hotDelta);
		Money sum = coldSum.add(hotSum).add(calc.getOdn());
		return new WaterResult(coldDelta, coldSum, hotDelta, hotSum, sum);
	}
}