package ru.rrozhkov.easykin.service.calculator;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class MeasureCalculator {
    public MeasureCalculator() {
    }

    public double calculate(int currentMeasure, int previousMeasure, double rate) {
        int delta = currentMeasure-previousMeasure;
        return delta*rate;
    }
}
