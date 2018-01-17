package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.impl.convert.DBReadingConverter;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ReadingHandler {
    private static String TABLENAME = "SERVICE_READING";

    public static String select = "SELECT * FROM "+TABLENAME;

    public static Collection<IReading> select() throws Exception {
        return DBManager.instance().select(select, new DBReadingConverter());
    }
}
