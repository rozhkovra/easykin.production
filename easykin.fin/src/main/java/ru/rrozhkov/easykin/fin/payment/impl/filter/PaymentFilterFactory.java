package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class PaymentFilterFactory {
	public static class PaymentFilterFactoryHolder {
		public static final PaymentFilterFactory INSTANCE = new PaymentFilterFactory();
	}

	public static PaymentFilterFactory instance(){
		return PaymentFilterFactoryHolder.INSTANCE;
	}

	private PaymentFilterFactory() {
	}

	public IFilter<IPayment> noFree(){
		return new NoFreeFilter();
	}
	public IFilter<IPayment> status(PaymentStatus status){
		return new StatusFilter(status);
	}
}