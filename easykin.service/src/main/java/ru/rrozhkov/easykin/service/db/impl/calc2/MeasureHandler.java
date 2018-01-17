package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.service.impl.convert.DBMeasureConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureHandler {
    private static String TABLENAME = "SERVICE_MEASURE";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static String selectForReading = "SELECT * FROM "+TABLENAME+" WHERE READINGID=#readingid#";

    public static Collection<IMeasure> select() throws Exception {
        return DBManager.instance().select(select, new DBMeasureConverter());
    }

    public static Collection<IMeasure> selectForReading(int id) throws Exception {
        return DBManager.instance().select(selectForReading.replace("#readingid#", String.valueOf(id)), new DBMeasureConverter());
    }

}
