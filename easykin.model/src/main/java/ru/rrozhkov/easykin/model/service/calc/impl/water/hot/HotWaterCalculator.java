package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;

public class HotWaterCalculator extends Calculator {
	public HotWaterCalculator(HotWaterCalc calc) {
		super(calc);
	}

	public HotWaterResult calculate() {
		HotWaterCalc calc = (HotWaterCalc)getCalc();
		double hotDelta = calc.getCurrentMesure()-calc.getPrevMesure();
		Money hotSum = MoneyFactory.create(calc.getRate()).multiply(hotDelta);
		Money sum = hotSum.add(calc.getOdn());
		return new HotWaterResult(hotDelta, hotSum, sum);
	}
}