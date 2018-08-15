package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.ServiceBean;

public class ServiceCalcCalculator extends ServiceCalculator {
	public ServiceCalcCalculator(ICalcBean calcBean) {
		super(calcBean);
	}

	public IServiceResult calculate() {
		ServiceBean calcBean = (ServiceBean) getCalcBean();
		Money itogo = Money.valueOf(0.00);
		for(ICalculation calc : calcBean.getBeans()){
			itogo.add(calc.getAmount());
		}
		return new ServiceResult(itogo);
	}
}