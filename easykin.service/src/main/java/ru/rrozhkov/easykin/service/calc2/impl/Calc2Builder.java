package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.db.impl.calc2.RateHandler;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public class Calc2Builder {
    final private static ReadingBuilder readingBuilder = new ReadingBuilder();
    public ServiceCalc buildNew() {
        Collection<IRate> rates;
        try {
            rates = RateHandler.selectForDate(DateUtil.lastDayOfMonth(DateUtil.today()));
        } catch (Exception e) {
            rates = StaticReadingDataProvider.rates2018_1;
        }
        IReading oldReading = readingBuilder.last();
        IReading newReading = readingBuilder.buildNew();
        return (ServiceCalc)Calc2Factory.createEmptyServiceCalc(oldReading, newReading, rates);
    }
}
