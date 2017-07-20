package ru.rrozhkov.easykin.model.service.calc.impl.gaz;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;

public class GazResult extends Result {
	private double delta;
	
	public GazResult(double delta, Money sum) {
		super(sum);
		this.delta = delta;
	}

	public double getDelta(){
		return delta;
	}
}