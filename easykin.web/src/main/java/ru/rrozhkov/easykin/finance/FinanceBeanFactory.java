package ru.rrozhkov.easykin.finance;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class FinanceBeanFactory {
    public FinanceBean financeBean(int num, IPayment payment) {
        return new FinanceBean(num, payment);
    }
}
