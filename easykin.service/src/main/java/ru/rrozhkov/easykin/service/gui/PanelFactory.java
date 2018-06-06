package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

public class PanelFactory {
	public Panel getPanel(Panel parent, ICalculation bean){
		if(bean instanceof GazCalc)
			return new GazPanel(parent, bean);
		else if (bean instanceof WaterCalc)
			return new WaterPanel(parent, bean);
		else if (bean instanceof ElectricityCalc)
			return new ElectricityPanel(parent, bean);
		else if (bean instanceof HotWaterCalc)
			return new HotWaterPanel(parent, bean);
		else if (bean instanceof DefaultCalc)
			return new DefaultPanel(parent, bean);
		else if (bean instanceof ServiceCalc)
			return new ServiceCalcPanel(bean);
		return null;
	}
}