package ru.rrozhkov.easykin.payment.db.impl;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.impl.convert.DBPaymentConverter;
import ru.rrozhkov.easykin.payment.impl.convert.PaymentMapConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 8/25/2017.
 */
public class PaymentHandler {
    private static String TABLENAME = "PAYMENT";

    public static String select = "SELECT "+TABLENAME+".* "+TABLENAME
            +" ORDER BY "+TABLENAME+".STATUSID, "+TABLENAME+".CATEGORYID";

    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, COMMENT, CREATEDATE, CATEGORYID, CLOSEDATE, STATUSID, AMOUNT)"
            +" VALUES(#id#,'#comment#','#createdate#',#categoryid#,NULL,#statusid#,#amount#)";

    public static Collection<IPayment> select() throws Exception{
        return DBManager.instance().select(select, new DBPaymentConverter());
    }


    public static int insert(IPayment payment) throws SQLException {
        try {
            Map<String, Object> map = new PaymentMapConverter().convert(payment);
            int id = DBManager.instance().nextId(TABLENAME);
            map.put("id", id);
            DBManager.instance().insert(insert,map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
