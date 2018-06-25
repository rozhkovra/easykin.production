package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;

public class CalculatorFactory extends ru.rrozhkov.easykin.service.calc.impl.calculator.CalculatorFactory {
	public static class Holder {
		public static final CalculatorFactory INSTANCE = new CalculatorFactory();
	}

	public static CalculatorFactory instance(){
		return Holder.INSTANCE;
	}

	private CalculatorFactory() {
	}

	public ICalculator getCalculator(ICalculation bean){
		ICalculator calculator = super.getCalculator(bean);
		if (calculator == null) {
			if (bean instanceof MeasureCalc)
				calculator = new MeasureCalculator((MeasureCalc) bean);
		}
		return calculator;
	}
}