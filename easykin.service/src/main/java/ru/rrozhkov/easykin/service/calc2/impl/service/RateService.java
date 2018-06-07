package ru.rrozhkov.easykin.service.calc2.impl.service;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.db.impl.calc2.RateHandler;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 07.06.2018.
 */
public class RateService {
    final private static RateHandler rateHandler = new RateHandler();

    public Collection<IRate> rates(Date date) {
        Collection<IRate> rates;
        try {
            rates = rateHandler.selectForDate(date);
        } catch (Exception e) {
            rates = StaticReadingDataProvider.rates2018_1;
        }
        return rates;
    }
}
