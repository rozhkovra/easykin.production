package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.DefaultBean;


public class DefaultCalculator extends ServiceCalculator {
	public DefaultCalculator(ICalcBean calcBean) {
		super(calcBean);
	}

	public IServiceResult calculate() {
		DefaultBean bean = (DefaultBean)getCalcBean();
		return new ServiceResult(bean.getPrice());
	}
}