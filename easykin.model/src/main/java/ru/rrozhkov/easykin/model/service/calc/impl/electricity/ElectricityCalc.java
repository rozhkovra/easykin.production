package ru.rrozhkov.easykin.model.service.calc.impl.electricity;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.OdnSimpleCalc;

public class ElectricityCalc extends OdnSimpleCalc {


	public ElectricityCalc(int prevMesure, int currentMesure, Money rate,
			Money odn, boolean isPaid) {
		super(prevMesure, currentMesure, rate, odn, isPaid);
	}
	
	public CalculationType getType() {
		return CalculationType.ELECTRICITY;
	}
}