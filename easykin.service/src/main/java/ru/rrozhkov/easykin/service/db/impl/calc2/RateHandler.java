package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.lib.db.impl.DBManager;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class RateHandler {
    private static String TABLENAME = "SERVICE_RATE";

    public static String select = "SELECT * FROM " + TABLENAME;

    public static String selectForDate = "SELECT * FROM " + TABLENAME + " WHERE '#rateDate#' between DATEFROM and DATETO";

    public static Collection<IRate> select() throws Exception {
        return DBManager.instance().select(select, ServiceConverterFactory.rate());
    }
    public static Collection<IRate> selectForDate(Date rateDate) throws Exception {
        return DBManager.instance().select(selectForDate.replace("#rateDate#", DateUtil.formatSql(rateDate)), ServiceConverterFactory.rate());
    }
}
