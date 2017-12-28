package ru.rrozhkov.easykin.model.service.calc.impl.def;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

public class DefaultCalc extends Calculation {
	private Money price;
	private CalculationType type;

	public DefaultCalc(CalculationType type, Money price, boolean isPaid) {
		super(isPaid);
		this.price = price;
		this.type = type;
	}

	public Money getPrice() {
		return price;
	}

	public CalculationType getType() {
		return type;
	}

	public void setPrice(Money price) {
		this.price = price;
	}	
}