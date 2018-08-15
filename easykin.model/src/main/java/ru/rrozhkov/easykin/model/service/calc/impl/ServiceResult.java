package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;

public class ServiceResult implements IServiceResult {
	protected Money sum;
	public ServiceResult(Money sum){
		this.sum = sum;
	}
	public Money getResult(){return sum;}
	
	@Override
	public String toString() {
		return FormatUtil.formatMoney(getResult());
	}
}