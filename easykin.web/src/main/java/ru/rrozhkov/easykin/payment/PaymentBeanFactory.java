package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class PaymentBeanFactory {
    public PaymentBean paymentBean(int num, IPayment payment) {
        return new PaymentBean(num,payment);
    }
}
