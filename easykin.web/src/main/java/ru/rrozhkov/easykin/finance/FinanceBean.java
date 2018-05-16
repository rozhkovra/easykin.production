package ru.rrozhkov.easykin.finance;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.PaymentBean;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class FinanceBean extends PaymentBean{
    public FinanceBean(int num, IPayment payment) {
        super(num, payment);
    }
}
