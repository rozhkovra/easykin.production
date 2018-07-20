package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

public abstract class OdnSimpleCalc extends SimpleCalc {
	protected Money odn;
	
	public OdnSimpleCalc(double prevMesure, double currentMesure, Money rate,
			Money odn, boolean isPaid, CalculationType type) {
		super(prevMesure, currentMesure, rate, isPaid, type);
		this.odn = odn;
	}
	public Money getOdn() {
		return odn;
	}
	public void setOdn(Money odn) {
		this.odn = odn;
	}
}