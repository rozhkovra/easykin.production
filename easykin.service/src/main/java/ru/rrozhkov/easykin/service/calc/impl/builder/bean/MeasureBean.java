package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class MeasureBean implements ICalcBuildBean {
    private Collection<Integer> prevMeasure;
    private Collection<Integer> currentMeasure;
    private Money rate;
    private boolean isPaid;
    private CalculationType type;

    public MeasureBean(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure, Money rate, boolean isPaid, CalculationType type) {
        this.prevMeasure = prevMeasure;
        this.currentMeasure = currentMeasure;
        this.rate = rate;
        this.isPaid = isPaid;
        this.type = type;
    }

    public Collection<Integer> getPrevMeasure() {
        return prevMeasure;
    }

    public Collection<Integer> getCurrentMeasure() {
        return currentMeasure;
    }

    public Money getRate() {
        return rate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public CalculationType getType() {
        return type;
    }
}
