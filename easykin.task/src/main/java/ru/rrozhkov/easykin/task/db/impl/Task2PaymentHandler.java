package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.task.impl.convert.DBTask2PersonConverter;
import ru.rrozhkov.easykin.task.impl.convert.Task2PaymentMapConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PaymentHandler {
    private static String TABLENAME = "TASK2PAYMENT";
    public static String select = "SELECT "+TABLENAME+".* FROM "+TABLENAME;
    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, PAYMENT, TASK)"
            +" VALUES(#id#,#payment#,#task#)";

    public static Collection<ITask2Payment> select() throws Exception {
        return DBManager.instance().select(select, new DBTask2PersonConverter());
    }
    public static int insert(ITask2Payment t2p) throws SQLException{
        try {
            Map<String, Object> map = new Task2PaymentMapConverter().convert(t2p);
            int id = DBManager.instance().nextId(TABLENAME);
            map.put("id", id);
            DBManager.instance().insert(insert,map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
