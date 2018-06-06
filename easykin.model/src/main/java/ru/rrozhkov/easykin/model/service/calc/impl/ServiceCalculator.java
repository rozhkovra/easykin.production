package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.IResult;

public class ServiceCalculator extends Calculator {
	private static final CalculatorFactory calculatorFactory = new CalculatorFactory();

	public ServiceCalculator(ICalculation calcBean) {
		super(calcBean);
	}

	public ServiceResult calculate() {
		ServiceCalc calcBean = (ServiceCalc)getCalc();
		Money itogo = Money.valueOf(0.00);
		for(ICalculation calc : calcBean.calcs()){
			ICalculator calculator = calculatorFactory.getCalculator(calc);
			if(calculator!=null) {
				IResult result = calculator.calculate();
				itogo.add(result.getResult());
			}
		}
		return new ServiceResult(itogo);
	}
}