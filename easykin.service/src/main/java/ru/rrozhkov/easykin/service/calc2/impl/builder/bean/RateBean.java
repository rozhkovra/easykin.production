package ru.rrozhkov.easykin.service.calc2.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class RateBean implements ICalcBuildBean {
    private IReading newReading;
    private Collection<IRate> rates;
    private CalculationType type;

    public RateBean(IReading newReading, Collection<IRate> rates, CalculationType type) {
        this.newReading = newReading;
        this.rates = rates;
        this.type = type;
    }

    public IReading getNewReading() {
        return newReading;
    }

    public Collection<IRate> getRates() {
        return rates;
    }

    public CalculationType getType() {
        return type;
    }
}
