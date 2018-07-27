package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.HotWaterCalc;

public class PanelFactory {
	public static class Holder {
		public static final PanelFactory INSTANCE = new PanelFactory();
	}

	public static PanelFactory instance(){
		return Holder.INSTANCE;
	}

	private PanelFactory() {
	}

	public GUIPanel getPanel(Panel parent, ICalculation bean){
		if(bean instanceof GazCalc)
			return GazPanel.create(parent, bean);
		else if (bean instanceof WaterCalc)
			return WaterPanel.create(parent, bean);
		else if (bean instanceof ElectricityCalc)
			return ElectricityPanel.create(parent, bean);
		else if (bean instanceof HotWaterCalc)
			return HotWaterPanel.create(parent, bean);
		else if (bean instanceof ServiceCalc)
			return ServiceCalcPanel.create(bean);
		return DefaultPanel.create(parent, bean);
	}
}