package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public abstract class SimpleCalc extends Calculation {
	protected double prevMesure;
	protected double currentMesure; 
	protected Money rate;
	
	public SimpleCalc(double prevMesure, double currentMesure, Money rate, boolean isPaid) {
		super(isPaid);
		this.prevMesure = prevMesure;
		this.currentMesure = currentMesure;
		this.rate = rate;
	}
	
	public double getPrevMesure() {
		return prevMesure;
	}
	public double getCurrentMesure() {
		return currentMesure;
	}
	public Money getRate() {
		return rate;
	}

	public void setPrevMesure(double prevMesure) {
		this.prevMesure = prevMesure;
	}

	public void setCurrentMesure(double currentMesure) {
		this.currentMesure = currentMesure;
	}

	public void setRate(Money rate) {
		this.rate = rate;
	}
}