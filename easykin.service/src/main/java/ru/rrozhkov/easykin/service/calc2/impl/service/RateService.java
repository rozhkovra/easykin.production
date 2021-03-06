package ru.rrozhkov.easykin.service.calc2.impl.service;

import ru.rrozhkov.easykin.core.db.IEntity;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.db.impl.calc2.RateHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.ServiceCalc2HandlerFactory;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class RateService extends EntityService {
    final private static RateHandler rateHandler = ServiceCalc2HandlerFactory.instance().rate();

    public static class Holder {
        public static final RateService INSTANCE = new RateService();
    }

    public static RateService instance(){
        return Holder.INSTANCE;
    }

    private RateService() {
        super(rateHandler);
    }

    @Override
    public int createOrUpdate(IEntity entity) {
        return -1;
    }

    public Collection<IRate> rates(Date date) {
        Collection<IRate> rates;
        try {
            rates = rateHandler.selectForDate(date);
        } catch (Exception e) {
            rates = StaticReadingDataProvider.rates2018_2;
        }
        return rates;
    }
}
