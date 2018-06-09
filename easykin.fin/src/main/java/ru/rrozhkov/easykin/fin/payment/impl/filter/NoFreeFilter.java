package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class NoFreeFilter implements IFilter<IPayment> {
	protected NoFreeFilter() {}
	public boolean filter(IPayment obj) {
		return !obj.getAmount().free();
	}
}