package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;

public class HotWaterResult extends DefaultResult {
	private double hotDelta;
	private Money hotSum;
	
	public HotWaterResult(double hotDelta,
			Money hotSum, Money sum) {
		super(sum);
		this.hotDelta = hotDelta;
		this.hotSum = hotSum;
	}
	public double getHotDelta() {
		return hotDelta;
	}
	public Money getHotSum() {
		return hotSum;
	}
}