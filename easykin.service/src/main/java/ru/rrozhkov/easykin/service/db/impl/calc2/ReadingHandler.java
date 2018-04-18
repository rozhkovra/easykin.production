package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.convert.DBReadingConverter;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ReadingMapConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ReadingHandler {
    private static String TABLENAME = "SERVICE_READING";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, REDDATE)"
            +" VALUES(#id#,'#reddate#')";


    public static Collection<IReading> select() throws Exception {
        return DBManager.instance().select(select, new DBReadingConverter());
    }


    public static int insert(IReading reading) throws SQLException {
        try {
            Map<String, Object> map = new ReadingMapConverter().convert(reading);
            int id = DBManager.instance().nextId(TABLENAME);
            map.put("id", id);
            DBManager.instance().insert(insert, map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
