package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.calc.impl.calculator.*;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.MeasureCalculatorAdapter;

public class CalculatorFactory {
	public static class Holder {
		public static final CalculatorFactory INSTANCE = new CalculatorFactory();
	}

	public static CalculatorFactory instance(){
		return Holder.INSTANCE;
	}

	protected CalculatorFactory() {
	}

	public ICalculator getCalculator(ICalculation bean){
		if (bean instanceof ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc)
			return new ru.rrozhkov.easykin.service.calc2.impl.calculator.WaterCalculatorAdapter((ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc)bean);
		else if (bean instanceof MeasureCalc)
			return new MeasureCalculatorAdapter((MeasureCalc) bean);
		else if (bean instanceof ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc)
			return new ru.rrozhkov.easykin.service.calc.impl.calculator.WaterCalculatorAdapter((ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc)bean);
		else if(bean instanceof GazCalc)
			return new GazCalculator((GazCalc)bean);
		else if (bean instanceof ElectricityCalc)
			return new ElectricityCalculator((ElectricityCalc)bean);
		else if (bean instanceof HotWaterCalc)
			return new HotWaterCalculator((HotWaterCalc) bean);
		else if (bean instanceof ServiceCalc)
			return new ServiceCalculator(bean);
		return new DefaultCalculator(bean);
	}
}