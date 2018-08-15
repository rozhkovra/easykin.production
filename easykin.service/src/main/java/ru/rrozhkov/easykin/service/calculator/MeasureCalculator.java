package ru.rrozhkov.easykin.service.calculator;

import ru.rrozhkov.easykin.core.calculation.ICalculator;
import ru.rrozhkov.easykin.core.calculation.IResult;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class MeasureCalculator implements ICalculator {
    private int currentMeasure;
    private int previousMeasure;
    private double rate;

    public MeasureCalculator(int currentMeasure, int previousMeasure, double rate) {
        this.currentMeasure = currentMeasure;
        this.previousMeasure = previousMeasure;
        this.rate = rate;
    }

    public IResult calculate() {
        int delta = currentMeasure-previousMeasure;
        return new CalcResult(delta*rate);
    }
}
