package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.service.RateService;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public class Calc2Builder {
    final private static ReadingBuilder readingBuilder = new ReadingBuilder();
    final private static Calc2Factory calcFactory = new Calc2Factory();
    final private static RateService rateService = new RateService();

    public ICalculation buildNew() {
        Collection<IRate> rates = rateService.rates(DateUtil.lastDayOfMonth());
        IReading oldReading = readingBuilder.last();
        IReading newReading = readingBuilder.buildNew();
        return calcFactory.createEmptyServiceCalc(oldReading, newReading, rates);
    }
}
