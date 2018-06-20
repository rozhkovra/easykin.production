package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

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
		else if (bean instanceof DefaultCalc)
			return DefaultPanel.create(parent, bean);
		else if (bean instanceof ServiceCalc)
			return ServiceCalcPanel.create(bean);
		return null;
	}
}