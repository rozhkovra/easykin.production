package ru.rrozhkov.easykin.finance;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;

import java.util.Collection;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class FinanceAdapter {
    private static final FinanceBeanFactory financeBeanFactory = new FinanceBeanFactory();
    private static final PaymentService paymentService = PaymentService.instance();

    public static Collection<FinanceBean> finance() {
        Collection<FinanceBean> beans = CollectionUtil.create();
        Collection<IPayment> payments = paymentService.paymentsPlan();
        for (IPayment peyment : payments) {
            beans.add(financeBeanFactory.financeBean(beans.size()+1,peyment));
        }
        return beans;
    }
}
