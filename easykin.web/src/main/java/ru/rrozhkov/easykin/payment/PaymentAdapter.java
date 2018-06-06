package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class PaymentAdapter {
    private static final PaymentBeanFactory paymentBeanFactory = new PaymentBeanFactory();

    public Collection<PaymentBean> payments() {
        Collection<PaymentBean> beans = CollectionUtil.create();
        Collection<IPayment> payments = Module.finance();
        int i =0;
        for (IPayment peyment : payments) {
            beans.add(paymentBeanFactory.paymentBean(++i,peyment));
        }
        return beans;
    }
}
