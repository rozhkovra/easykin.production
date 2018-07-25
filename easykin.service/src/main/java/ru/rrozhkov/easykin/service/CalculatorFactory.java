package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.service.calc.impl.calculator.*;

public class CalculatorFactory extends CalculatorAbstractFactory {
	protected CalculatorFactory() {
	}

	public ICalculator getCalculator(ICalculation bean){
		if (bean instanceof WaterCalc)
			return new WaterCalculatorAdapter(bean);
		else if(bean instanceof GazCalc)
			return new GazCalculator(bean);
		else if (bean instanceof ElectricityCalc)
			return new ElectricityCalculator(bean);
		else if (bean instanceof HotWaterCalc)
			return new HotWaterCalculator(bean);
		else if (bean instanceof ServiceCalc)
			return new ServiceCalculator(bean);
		return new DefaultCalculator(bean);
	}
}