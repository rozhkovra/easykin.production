package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public abstract class SimpleCalc extends Calculation {
	protected double prevMeasure;
	protected double currentMeasure;
	protected Money rate;
	
	public SimpleCalc(double prevMesure, double currentMesure, Money rate, boolean isPaid) {
		super(isPaid);
		this.prevMeasure = prevMesure;
		this.currentMeasure = currentMesure;
		this.rate = rate;
	}
	
	public double getPrevMeasure() {
		return prevMeasure;
	}
	public double getCurrentMeasure() {
		return currentMeasure;
	}
	public Money getRate() {
		return rate;
	}

	public void setPrevMeasure(double prevMeasure) {
		this.prevMeasure = prevMeasure;
	}

	public void setCurrentMeasure(double currentMeasure) {
		this.currentMeasure = currentMeasure;
	}

	public void setRate(Money rate) {
		this.rate = rate;
	}
}