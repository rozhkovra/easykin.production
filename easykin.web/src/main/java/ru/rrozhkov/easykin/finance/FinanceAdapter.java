package ru.rrozhkov.easykin.finance;

import ru.rrozhkov.easykin.fin.Module;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 16.05.2018.
 */
public class FinanceAdapter {
    public static Collection<FinanceBean> finance() {
        Collection<FinanceBean> beans = CollectionUtil.create();
        Collection<IPayment> payments = Module.finance();
        int i =0;
        for (IPayment peyment : payments) {
            beans.add(new FinanceBean(++i,peyment));
        }
        return beans;
    }
}
