package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.filter.IFilter;

public class NoFreeFilter implements IFilter<IPayment> {
	public boolean filter(IPayment obj) {
		return !obj.getAmount().free();
	}
}