package ru.rrozhkov.easykin.service.calc2.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class CalcBuilderFactory {
    public ICalcBean measure(IReading oldReading, IReading newReading, Collection<IRate> rates, CalculationType type) {
        return new MeasureBean(oldReading, newReading, rates, type);
    }

    public ICalcBean rate(IReading newReading, Collection<IRate> rates, CalculationType type) {
        return new RateBean(newReading, rates, type);
    }
    public ICalcBean water(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        return new WaterBean(oldReading, newReading, rates);
    }
}
