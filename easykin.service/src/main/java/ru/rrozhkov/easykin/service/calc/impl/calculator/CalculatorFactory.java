package ru.rrozhkov.easykin.service.calc.impl.calculator;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

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
		if(bean instanceof GazCalc)
			return new GazCalculator((GazCalc)bean);
		else if (bean instanceof WaterCalc)
			return new WaterCalculator((WaterCalc)bean);
		else if (bean instanceof ElectricityCalc)
			return new ElectricityCalculator((ElectricityCalc)bean);
		else if (bean instanceof HotWaterCalc)
			return new HotWaterCalculator((HotWaterCalc) bean);
		else if (bean instanceof DefaultCalc)
			return new DefaultCalculator((DefaultCalc) bean);
		else if (bean instanceof ServiceCalc)
			return new ServiceCalculator(bean);
		return null;
	}
}