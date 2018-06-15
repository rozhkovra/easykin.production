package ru.rrozhkov.easykin.service.db.impl.calc2;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.service.calc2.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class RateHandler extends EntityHandler {
    private static final ServiceConverterFactory converterFactory = ServiceConverterFactory.instance();
    private final String selectForDate = "SELECT * FROM " + getTableName() + " WHERE '#rateDate#' between DATEFROM and DATETO";

    public static class Holder {
        public static final RateHandler INSTANCE = new RateHandler();
    }

    public static RateHandler instance(){
        return Holder.INSTANCE;
    }

    private RateHandler() {
    }

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
