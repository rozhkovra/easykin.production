package ru.rrozhkov.easykin.model.service.calc2.impl.measure;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.impl.DefaultResult;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureResult extends DefaultResult {
    private double delta;
    private Money deltaSum;

    public MeasureResult(double delta, Money deltaSum, Money sum) {
        super(sum);
        this.delta = delta;
        this.deltaSum = deltaSum;
    }

    public double getDelta() {
        return delta;
    }

    public Money getDeltaSum() {
        return deltaSum;
    }
}
