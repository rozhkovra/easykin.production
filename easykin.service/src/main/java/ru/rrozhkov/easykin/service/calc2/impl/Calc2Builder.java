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
public class Calc2Builder {
    private static final ReadingBuilder readingBuilder = ReadingBuilder.instance();
    private static final Calc2Factory calcFactory = Calc2Factory.instance();
    private static final RateService rateService = RateService.instance();

    public static class Holder {
        public static final Calc2Builder INSTANCE = new Calc2Builder();
    }

    public static Calc2Builder instance(){
        return Holder.INSTANCE;
    }

    private Calc2Builder() {
    }

    public ICalculation buildNew() {
        Collection<IRate> rates = rateService.rates(DateUtil.lastDayOfMonth());
        IReading oldReading = readingBuilder.last();
        IReading newReading = readingBuilder.buildNew();
        return calcFactory.createEmptyServiceCalc(oldReading, newReading, rates);
    }
}
