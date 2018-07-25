package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class ElectricityCalcBuilder implements ICalcBuilder {
    private int prevMeasure;
    private int currentMeasure;
    private Money rate;
    private boolean isPaid;

    public ElectricityCalcBuilder() {
    }

    public void init(int prevMeasure, int currentMeasure, Money rate, boolean isPaid) {
        this.prevMeasure = prevMeasure;
        this.currentMeasure = currentMeasure;
        this.rate = rate;
        this.isPaid = isPaid;
    }

    public ICalculation build() {
        return new ElectricityCalc(prevMeasure, currentMeasure, rate, Money.valueOf(0), isPaid);
    }
}
