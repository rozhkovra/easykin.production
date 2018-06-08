package ru.rrozhkov.easykin.payment.db.impl;

import ru.rrozhkov.easykin.payment.impl.convert.PaymentConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

/**
 * Created by rrozhkov on 8/25/2017.
 */
public class PaymentHandler extends EntityHandler {
    private static final PaymentConverterFactory paymentConverterFactory = PaymentConverterFactory.instance();

    public static class PaymentHandlerHolder {
        public static final PaymentHandler INSTANCE = new PaymentHandler();
    }

    public static PaymentHandler instance(){
        return PaymentHandlerHolder.INSTANCE;
    }

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
        return "SELECT * "+getTableName()
                +" ORDER BY STATUSID, CATEGORYID";
    }

    @Override
    protected String getInsert() {
        return "INSERT INTO "+getTableName()
                +"(ID, COMMENT, CREATEDATE, CATEGORYID, CLOSEDATE, STATUSID, AMOUNT)"
                +" VALUES(#id#,'#comment#','#createdate#',#categoryid#,NULL,#statusid#,#amount#)";
    }
}
