package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;

import java.util.Collection;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class PaymentAdapter {
    private static final PaymentBeanFactory paymentBeanFactory = new PaymentBeanFactory();
    private static final PaymentService paymentService = PaymentService.instance();

    public Collection<PaymentBean> payments() {
        Collection<PaymentBean> beans = CollectionUtil.create();
        Collection<IPayment> payments = paymentService.paymentsFact();
        for (IPayment peyment : payments) {
            beans.add(paymentBeanFactory.paymentBean(beans.size()+1,peyment));
        }
        return beans;
    }
}
