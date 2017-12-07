package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

public class ShortPanelFactory {
	public static Panel getPanel(Panel parent, ICalculation bean){
		return new ShortPanel(parent,(Calculation)bean);
	}
}