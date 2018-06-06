package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
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
public class MeasureHandler {
    private static final IDBManager dbManager = DBManager.instance();
    private static final ServiceConverterFactory converterFactory = new ServiceConverterFactory();
    private static final IEntityConverter converter = converterFactory.measure();

    private static String TABLENAME = "SERVICE_MEASURE";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static String selectForReading = "SELECT * FROM "+TABLENAME+" WHERE READINGID=#readingid#";

    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, READINGID, MEASURETYPE, MEASUREVALUE)"
            +" VALUES(#id#, #readingid#, '#measuretype#','#measurevalue#')";

    public Collection<IMeasure> select() throws Exception {
        return dbManager.select(select, converter);
    }

    public Collection<IMeasure> selectForReading(int id) throws Exception {
        return dbManager.select(selectForReading.replace("#readingid#", String.valueOf(id)), converter);
    }

    public int insert(IMeasure measure) throws SQLException {
        try {
            Map<String, Object> map = converter.map(measure);
            int id = dbManager.nextId(TABLENAME);
            map.put("id", id);
            dbManager.insert(insert, map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

}
