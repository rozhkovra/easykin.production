package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

public abstract class SimpleCalc extends Calculation {
	protected double prevMeasure;
	protected double currentMeasure;
	protected Money rate;
	
	public SimpleCalc(double prevMeasure, double currentMeasure, Money rate, boolean isPaid, CalculationType type) {
		super(-1, -1, type, isPaid, rate);
		this.prevMeasure = prevMeasure;
		this.currentMeasure = currentMeasure;
		this.rate = rate;
	}

	public SimpleCalc(int id, int readingId, IPayment payment, double prevMeasure, double currentMeasure, Money rate, CalculationType type) {
		super(id, readingId, type, payment);
		this.prevMeasure = prevMeasure;
		this.currentMeasure = currentMeasure;
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