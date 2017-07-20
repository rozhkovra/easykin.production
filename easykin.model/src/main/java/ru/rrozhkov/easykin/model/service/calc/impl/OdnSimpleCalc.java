package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public abstract class OdnSimpleCalc extends SimpleCalc {
	protected Money odn;
	
	public OdnSimpleCalc(double prevMesure, double currentMesure, Money rate,
			Money odn, boolean isPaid) {		
		super(prevMesure, currentMesure, rate, isPaid);
		this.odn = odn;
	}
	public Money getOdn() {
		return odn;
	}
	public void setOdn(Money odn) {
		this.odn = odn;
	}
}