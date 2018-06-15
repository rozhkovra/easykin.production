package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

public class ShortPanelFactory {
	public Panel getPanel(Panel parent, ICalculation bean){
		return new ShortPanel(parent,(Calculation)bean);
	}
}