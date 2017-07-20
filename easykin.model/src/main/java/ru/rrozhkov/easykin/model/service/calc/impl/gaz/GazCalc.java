package ru.rrozhkov.easykin.model.service.calc.impl.gaz;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.SimpleCalc;

public class GazCalc extends SimpleCalc {
	public GazCalc(double gazPrevMesure, double gazCurrentMesure,
			Money gazRate, boolean isPaid) {
		super(gazPrevMesure, gazCurrentMesure,gazRate,isPaid);
	}

	public CalculationType getType() {
		return CalculationType.GAZ;
	}
}