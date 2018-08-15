package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.MeasureBean;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.MeasureBeanAdapter;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

public class MeasureCalculatorAdapter extends ServiceCalculator {
	public MeasureCalculatorAdapter(ICalcBean bean) {
		super(bean);
	}

	public IServiceResult calculate() {

		MeasureBean calcBean = (MeasureBean) getCalcBean();
		MeasureBeanAdapter beanAdapter = new MeasureBeanAdapter(calcBean);
		int currMeasure = beanAdapter.getCurrentMeasure();
		int prevMeasure = beanAdapter.getPrevMeasure();
		double rate = calcBean.getRate().getValue();
		MeasureCalculator measureCalculator = new MeasureCalculator(currMeasure, prevMeasure, rate);
		double dSum = (Double)measureCalculator.calculate().getResult();
		Money sum = Money.valueOf(dSum);
		return new ServiceResult(sum);
	}
}