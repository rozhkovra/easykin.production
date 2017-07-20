package ru.rrozhkov.easykin.model.service.calc.impl.def;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.Result;

public class DefaultResult extends Result {
	public DefaultResult(Money sum) {
		super(sum);
	}
}