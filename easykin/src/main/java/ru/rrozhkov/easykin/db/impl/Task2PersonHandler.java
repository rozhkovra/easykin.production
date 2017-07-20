package ru.rrozhkov.easykin.db.impl;

import ru.rrozhkov.easykin.model.task.ITask2Person;
import ru.rrozhkov.easykin.model.task.impl.convert.DBTask2PersonConverter;
import ru.rrozhkov.easykin.model.task.impl.convert.T2PMapConverter;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2PersonHandler {
    private static String TABLENAME = "TASK2PERSON";
    public static String select = "SELECT "+TABLENAME+".* FROM "+TABLENAME;
    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, PERSON, TASK)"
            +" VALUES(#id#,#person#,#task#)";

    public static Collection<ITask2Person> select() throws SQLException {
        return EasyKinDBManager.instance().select(select, new DBTask2PersonConverter());
    }
    public static int insert(ITask2Person t2p) throws SQLException{
        try {
            Map<String, Object> map = new T2PMapConverter().convert(t2p);
            int id = EasyKinDBManager.instance().nextId(TABLENAME);
            map.put("id", id);
            EasyKinDBManager.instance().insert(insert,map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
