package ru.rrozhkov.easykin.model.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.lib.filter.IFilter;

public class PaymentFilterFactory {
	public static IFilter<IPayment> noFree(){
		return new NoFreeFilter();
	}
	public static IFilter<IPayment> status(PaymentStatus status){
		return new StatusFilter(status);
	}
}