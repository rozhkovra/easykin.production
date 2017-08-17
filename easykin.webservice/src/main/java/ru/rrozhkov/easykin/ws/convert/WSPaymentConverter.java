package ru.rrozhkov.easykin.ws.convert;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.ws.bean.PaymentBean;
import ru.rrozhkov.lib.convert.IConverter;

public class WSPaymentConverter implements IConverter<IPayment, PaymentBean> {

	public PaymentBean convert(IPayment payment) {
		PaymentBean bean = new PaymentBean();
		bean.setCategory(payment.getCategory().toString());
		bean.setComment(payment.getComment());
		bean.setAmount(payment.getAmount().getValue());
		bean.setDate(payment.getDate());
		bean.setStatus(PaymentStatus.status(payment.getStatus()));
		return bean;
	}
	
}
