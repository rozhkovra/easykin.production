package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;

/**
 * Created by rrozhkov on 26.07.2018.
 */
public class MeasureResult extends DefaultResult {
    private double delta;

    public MeasureResult(double delta, Money sum) {
        super(sum);
        this.delta = delta;
    }

    public double getDelta() {
        return delta;
    }
}
