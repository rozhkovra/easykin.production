package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class StatusFilter implements IFilter<IPayment> {
	private PaymentStatus status;
	protected StatusFilter(PaymentStatus status) {
		this.status = status;
	}
	public boolean filter(IPayment obj) {
		return status.equals(obj.getStatus());
	}
}
