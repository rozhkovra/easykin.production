package ru.rrozhkov.easykin.service.calc2.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class WaterBean implements ICalcBuildBean {
    private IReading oldReading;
    private IReading newReading;
    private Collection<IRate> rates;

    public WaterBean(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        this.oldReading = oldReading;
        this.newReading = newReading;
        this.rates = rates;
    }

    public IReading getOldReading() {
        return oldReading;
    }

    public IReading getNewReading() {
        return newReading;
    }

    public Collection<IRate> getRates() {
        return rates;
    }
}
