package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ReadingHandler {
    private static final IDBManager dbManager = DBManager.instance();
    private static final ServiceConverterFactory converterFactory = new ServiceConverterFactory();
    private static final IEntityConverter converter = converterFactory.reading();


    private static String TABLENAME = "SERVICE_READING";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, REDDATE)"
            +" VALUES(#id#,'#reddate#')";


    public static Collection<IReading> select() throws Exception {
        return dbManager.select(select, converter);
    }


    public static int insert(IReading reading) throws SQLException {
        try {
            Map<String, Object> map = converter.map(reading);
            int id = dbManager.nextId(TABLENAME);
            map.put("id", id);
            dbManager.insert(insert, map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
}
