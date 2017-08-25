package ru.rrozhkov.easykin.payment.db.impl;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.payment.impl.convert.DBPaymentConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

/**
 * Created by rrozhkov on 8/25/2017.
 */
public class PaymentHandler {
    private static String TABLENAME = "PAYMENT";

    public static String select = "SELECT "+TABLENAME+".* "+TABLENAME
            +" ORDER BY "+TABLENAME+".STATUSID, "+TABLENAME+".CATEGORYID";

    public static Collection<ITask> select() throws Exception{
        return DBManager.instance().select(select, new DBPaymentConverter());
    }
}
