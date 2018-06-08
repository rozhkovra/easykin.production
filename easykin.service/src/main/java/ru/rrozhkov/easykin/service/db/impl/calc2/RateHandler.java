package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class RateHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = new ServiceConverterFactory();

    public String selectForDate = "SELECT * FROM " + getTableName() + " WHERE '#rateDate#' between DATEFROM and DATETO";

    @Override
    protected String getTableName() {
        return "SERVICE_RATE";
    }

    @Override
    protected IEntityConverter getConverter() {
        return converterFactory.rate();
    }

    public Collection<IRate> selectForDate(Date rateDate) throws Exception {
        return dbManager().select(selectForDate.replace("#rateDate#", DateUtil.formatSql(rateDate)), getConverter());
    }
}
