package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;

public class WaterResult extends DefaultResult {
	private double coldDelta;
	private Money coldSum;
	private double hotDelta;
	private Money hotSum;
	
	public WaterResult(double coldDelta, Money coldSum, double hotDelta,
			Money hotSum, Money sum) {
		super(sum);
		this.coldDelta = coldDelta;
		this.coldSum = coldSum;
		this.hotDelta = hotDelta;
		this.hotSum = hotSum;
	}

	public double getColdDelta() {
		return coldDelta;
	}

	public Money getColdSum() {
		return coldSum;
	}

	public double getHotDelta() {
		return hotDelta;
	}

	public Money getHotSum() {
		return hotSum;
	}
}