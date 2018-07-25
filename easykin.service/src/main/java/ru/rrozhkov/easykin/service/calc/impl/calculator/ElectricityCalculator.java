package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityResult;

public class ElectricityCalculator extends Calculator {
	
	public ElectricityCalculator(ICalculation bean) {
		super(bean);
	}

	public ElectricityResult calculate() {
		ElectricityCalc calcBean = (ElectricityCalc)getCalc();
		double delta = calcBean.getCurrentMeasure()-calcBean.getPrevMeasure();
		Money deltaSum = MoneyFactory.create(calcBean.getRate()).multiply(delta);
		return new ElectricityResult(delta, deltaSum, deltaSum.add(calcBean.getOdn()));
	}
}