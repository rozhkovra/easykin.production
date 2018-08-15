package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;

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
		if(bean.getType().isGaz()
				|| bean.getType().isHotWater()
				|| bean.getType().isElectricity())
			return MeasurePanel.create(parent, bean);
		else if (bean.getType().isWater())
			return WaterPanel.create(parent, bean);
		else if (bean.getType().isAll())
			return ServiceCalcPanel.create(bean);
		return DefaultPanel.create(parent, bean);
	}
}