package ru.rrozhkov.easykin.model.service.calc.impl.def;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

public class DefaultCalc extends Calculation {
	private Money sum;
	private CalculationType type;

	public DefaultCalc(CalculationType type, Money sum, boolean isPaid) {
		super(isPaid);
		this.sum = sum;
		this.type = type;
	}

	public Money getSum() {
		return sum;
	}

	public CalculationType getType() {
		return type;
	}

	public void setSum(Money sum) {
		this.sum = sum;
	}	
}