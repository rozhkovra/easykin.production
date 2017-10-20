package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public abstract class DoubleSimpleCalc extends SimpleCalc {
	protected double prevMesure2;
	protected double currentMesure2;

	public DoubleSimpleCalc(double prevMesure2, double currentMesure2,
							double prevMesure, double currentMesure,
							Money rate, boolean isPaid) {
		super(prevMesure, currentMesure,rate, isPaid);
		this.prevMesure2 = prevMesure2;
		this.currentMesure2 = currentMesure2;
	}
	
	public double getPrevMesure2() {
		return prevMesure2;
	}
	public double getCurrentMesure2() {
		return currentMesure2;
	}

	public void setPrevMesure2(double prevMesure2) {
		this.prevMesure2 = prevMesure2;
	}

	public void setCurrentMesure2(double currentMesure2) {
		this.currentMesure2 = currentMesure2;
	}
}