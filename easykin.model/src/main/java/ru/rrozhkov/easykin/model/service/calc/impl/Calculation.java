package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;

public abstract class Calculation implements ICalculation{
	private boolean isPaid = false;
	public boolean isPaid() {return isPaid;}
	public void setPaid(boolean isPaid) {this.isPaid = isPaid;}
	public Calculation(boolean isPaid) {
		this.isPaid = isPaid;
	}	
}