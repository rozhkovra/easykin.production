package ru.rrozhkov.easykin.model.service.calc.impl.electricity;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;

public class ElectricityResult extends DefaultResult {
	private double delta;
	private Money deltaSum;

	public ElectricityResult(double delta, Money deltaSum, Money sum) {
		super(sum);
		this.delta = delta;
		this.deltaSum = deltaSum;
	}

	public double getDelta() {
		return delta;
	}

	public Money getDeltaSum() {
		return deltaSum;
	}
}