package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.service.calc2.impl.convert.DBMeasureConverter;
import ru.rrozhkov.easykin.service.calc2.impl.convert.MeasureMapConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureHandler {
    private static String TABLENAME = "SERVICE_MEASURE";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static String selectForReading = "SELECT * FROM "+TABLENAME+" WHERE READINGID=#readingid#";

    public static String insert = "INSERT INTO "+TABLENAME
            +"(ID, READINGID, MEASURETYPE, MEASUREVALUE)"
            +" VALUES(#id#, #readingid#, '#measuretype#','#measurevalue#')";

    public static Collection<IMeasure> select() throws Exception {
        return DBManager.instance().select(select, new DBMeasureConverter());
    }

    public static Collection<IMeasure> selectForReading(int id) throws Exception {
        return DBManager.instance().select(selectForReading.replace("#readingid#", String.valueOf(id)), new DBMeasureConverter());
    }

    public static int insert(IMeasure measure) throws SQLException {
        try {
            Map<String, Object> map = new MeasureMapConverter().convert(measure);
            int id = DBManager.instance().nextId(TABLENAME);
            map.put("id", id);
            DBManager.instance().insert(insert, map);
            return id;
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

}
