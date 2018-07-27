package ru.rrozhkov.easykin.service.calc2.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class CalcBuilderFactory {
    public ICalcBuildBean measure(IReading oldReading, IReading newReading, Collection<IRate> rates, CalculationType type) {
        return new MeasureBean(oldReading, newReading, rates, type);
    }

    public ICalcBuildBean rate(IReading newReading, Collection<IRate> rates, CalculationType type) {
        return new RateBean(newReading, rates, type);
    }
    public ICalcBuildBean water(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        return new WaterBean(oldReading, newReading, rates);
    }
}
