package ru.rrozhkov.easykin.payment.db.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.impl.convert.PaymentConverterFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 8/25/2017.
 */
public class PaymentHandler extends EntityHandler {
    private static final PaymentConverterFactory paymentConverterFactory = PaymentConverterFactory.instance();

    public static class Holder {
        public static final PaymentHandler INSTANCE = new PaymentHandler();
    }

    public static PaymentHandler instance(){
        return Holder.INSTANCE;
    }

    private String selectForId = "SELECT "+getTableName()+".* FROM "+getTableName()
            +" WHERE ID=#id#";

    @Override
    protected String getTableName() {
        return "PAYMENT";
    }

    @Override
    protected IEntityConverter getConverter() {
        return paymentConverterFactory.payment();
    }

    @Override
    protected String getSelect() {
        return "SELECT * FROM "+getTableName()
                +" ORDER BY STATUSID, CATEGORYID";
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, COMMENT, CREATEDATE, CATEGORYID, CLOSEDATE, STATUSID, AMOUNT)"
                +" VALUES(#id#,'#comment#','#createdate#',#categoryid#,NULL,#statusid#,#amount#)";
    }

    @Override
    protected String getUpdate() {
        return "UPDATE " + getTableName() + " SET COMMENT='#comment#', CREATEDATE='#createdate#', STATUSID=#statusid#,"
                + " CATEGORYID=#categoryid#, AMOUNT=#amount# WHERE ID=#id#";
    }


    public IPayment selectForId(int paymentId) throws Exception {
        Collection<IPayment> payments = dbManager().select(selectForId.replace("#id#", String.valueOf(paymentId)), getConverter());
        if(payments!=null && !payments.isEmpty())
            return CollectionUtil.get(payments, 0);
        return null;
    }
}
