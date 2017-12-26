package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public abstract class DoubleSimpleCalc extends SimpleCalc {
	protected double prevMeasure2;
	protected double currentMeasure2;

	public DoubleSimpleCalc(double prevMeasure2, double currentMeasure2,
							double prevMeasure, double currentMeasure,
							Money rate, boolean isPaid) {
		super(prevMeasure, currentMeasure,rate, isPaid);
		this.prevMeasure2 = prevMeasure2;
		this.currentMeasure2 = currentMeasure2;
	}
	
	public double getPrevMeasure2() {
		return prevMeasure2;
	}
	public double getCurrentMeasure2() {
		return currentMeasure2;
	}

	public void setPrevMeasure2(double prevMeasure2) {
		this.prevMeasure2 = prevMeasure2;
	}

	public void setCurrentMeasure2(double currentMeasure2) {
		this.currentMeasure2 = currentMeasure2;
	}
}