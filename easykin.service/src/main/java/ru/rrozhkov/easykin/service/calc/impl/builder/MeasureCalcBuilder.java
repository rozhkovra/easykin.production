package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

import java.util.Collection;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class MeasureCalcBuilder implements ICalcBuilder {
    private Collection<Integer> prevMeasure;
    private Collection<Integer> currentMeasure;
    private Money rate;
    private boolean isPaid;
    private CalculationType type;

    public MeasureCalcBuilder() {
    }

    public void init(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure, Money rate, boolean isPaid, CalculationType type) {
        this.prevMeasure = prevMeasure;
        this.currentMeasure = currentMeasure;
        this.rate = rate;
        this.isPaid = isPaid;
        this.type = type;
    }

    public ICalculation build() {
        return new MeasureCalc(prevMeasure, currentMeasure, rate, isPaid, type);
    }
}
