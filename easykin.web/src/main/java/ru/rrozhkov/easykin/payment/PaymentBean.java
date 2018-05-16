package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class PaymentBean {
    private int num;
    private IPayment payment;

    public PaymentBean(int num, IPayment payment) {
        this.num = num;
        this.payment = payment;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public IPayment getPayment() {
        return payment;
    }

    public void setPayment(IPayment payment) {
        this.payment = payment;
    }
}
