package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

public class PanelFactory {
	public static Panel getPanel(Panel parent, ICalculation bean){
		if(bean instanceof GazCalc)
			return new GazPanel(parent, (GazCalc) bean);
		else if (bean instanceof WaterCalc)
			return new WaterPanel(parent, (WaterCalc) bean);
		else if (bean instanceof ElectricityCalc)
			return new ElectricityPanel(parent, (ElectricityCalc) bean);
		else if (bean instanceof HotWaterCalc)
			return new HotWaterPanel(parent, (HotWaterCalc) bean);
		else if (bean instanceof DefaultCalc)
			return new DefaultPanel(parent, (DefaultCalc) bean);
		else if (bean instanceof ServiceCalc)
			return new ServiceCalcForm((ServiceCalc) bean);
		return null;
	}
}