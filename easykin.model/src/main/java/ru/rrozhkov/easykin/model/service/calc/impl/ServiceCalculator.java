package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import static ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory.getCalculator;

public class ServiceCalculator extends Calculator {
	public ServiceCalculator(ServiceCalc calcBean) {
		super(calcBean);
	}

	public ServiceResult calculate() {
		ServiceCalc calcBean = (ServiceCalc)getCalc();
		Money itogo = MoneyFactory.create();
		for(ICalculation calc : calcBean.calcs()){
			Calculation bean = (Calculation)calc;
			itogo.add(getCalculator(bean).calculate().getResult());
		}
		return new ServiceResult(itogo);
	}
}