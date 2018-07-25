package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;

public class ServiceResult extends DefaultResult {
	public ServiceResult(Money sum) {
		super(sum);
	}
}