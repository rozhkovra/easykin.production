package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.service.RateService;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public class Service2Builder {
    private static final ReadingBuilder readingBuilder = ReadingBuilder.instance();
    private static final Calc2Factory calcFactory = Calc2Factory.instance();
    private static final RateService rateService = RateService.instance();

    public static class Holder {
        public static final Service2Builder INSTANCE = new Service2Builder();
    }

    public static Service2Builder instance(){
        return Holder.INSTANCE;
    }

    private Service2Builder() {
    }

    public ICalculation buildNew() {
        Collection<IRate> rates = rateService.rates(DateUtil.lastDayOfMonth());
        IReading oldReading = readingBuilder.last();
        IReading newReading = readingBuilder.buildNew();
        return calcFactory.createEmptyServiceCalc(oldReading, newReading, rates);
    }
}
