package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.WaterBean;
import ru.rrozhkov.easykin.service.calculator.WaterCalculator;

public class WaterCalculatorAdapter extends ServiceCalculator {
	public WaterCalculatorAdapter(ICalcBean calc) {
		super(calc);
	}

	public IServiceResult calculate() {
		WaterBean calc = (WaterBean) getCalcBean();
		Money rateIn = calc.getInRate();
		Money rateOut = calc.getOutRate();
		int currCold = calc.getColdCurrentMeasure() + calc.getColdCurrentMeasure2();
		int prevCold = calc.getColdPrevMeasure() + calc.getColdPrevMeasure2();
		int currHot = calc.getHotCurrentMeasure() + calc.getHotCurrentMeasure2();
		int prevHot = calc.getHotPrevMeasure() + calc.getHotPrevMeasure2();
		WaterCalculator waterCalculator = new WaterCalculator(rateIn.getValue(), rateOut.getValue(),
				currCold, prevCold, currHot, prevHot);
		double result = (Double)waterCalculator.calculate().getResult();
		Money sum = Money.valueOf(result);
		return new ServiceResult(sum);
	}
}