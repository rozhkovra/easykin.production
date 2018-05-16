package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class PaymentAdapter {
    public static Collection<PaymentBean> payments() {
        Collection<PaymentBean> beans = CollectionUtil.create();
        Collection<IPayment> payments = Module.finance();
        int i =0;
        for (IPayment peyment : payments) {
            beans.add(new PaymentBean(++i,peyment));
        }
        return beans;
    }
}
