package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.task.ITask2Person;
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
public class Task2PersonHandler {
    final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();
    final private static IEntityConverter converter = taskConverterFactory.task2person();
    final private static IDBManager dbManager = DBManager.instance();

    private static String TABLENAME = "TASK2PERSON";
    public static String select = "SELECT "+TABLENAME+".* FROM "+TABLENAME;
    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, PERSON, TASK)"
            +" VALUES(#id#,#person#,#task#)";

    public static Collection<ITask2Person> select() throws Exception {
        return dbManager.select(select, converter);
    }
    public static int insert(ITask2Person t2p) throws SQLException{
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
