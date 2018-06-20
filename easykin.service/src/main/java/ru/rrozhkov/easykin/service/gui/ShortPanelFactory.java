package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

public class ShortPanelFactory {
	public static class Holder {
		public static final ShortPanelFactory INSTANCE = new ShortPanelFactory();
	}

	public static ShortPanelFactory instance(){
		return Holder.INSTANCE;
	}

	private ShortPanelFactory() {
	}

	public GUIPanel getPanel(GUIPanel parent, ICalculation bean){
		return new ShortPanel(parent,(Calculation)bean);
	}
}