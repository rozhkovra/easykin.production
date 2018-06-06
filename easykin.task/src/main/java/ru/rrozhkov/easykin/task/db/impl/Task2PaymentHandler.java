package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.ITask2Payment;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PaymentHandler {
    final private static TaskConverterFactory converterFactory = new TaskConverterFactory();
    final private static IEntityConverter converter = converterFactory.task2payment();
    final private static IDBManager dbManager = DBManager.instance();

    final private static String TABLENAME = "TASK2PAYMENT";
    final private static String select = "SELECT "+TABLENAME+".* FROM "+TABLENAME;
    final private static String insert = "INSERT INTO "+TABLENAME
            +"(ID, PAYMENT, TASK)"
            +" VALUES(#id#,#payment#,#task#)";

    public Collection<ITask2Payment> select() throws Exception {
        return dbManager.select(select, converter);
    }
    public int insert(ITask2Payment t2p) throws SQLException{
        try {
            Map<String, Object> map = converter.map(t2p);
            int id = dbManager.nextId(TABLENAME);
            map.put("id", id);
            dbManager.insert(insert,map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
