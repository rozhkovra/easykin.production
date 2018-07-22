package ru.rrozhkov.easykin.service.calculator;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class WaterCalculator {
    private static final MeasureCalculator measureCalculator = new MeasureCalculator();

    public double calculate(double inRate, double outRate, int coldCurrentMeasure, int coldPreviousMeasure, int hotCurrentMeasure, int hotPreviousMeasure) {
        double coldSum = measureCalculator.calculate(coldCurrentMeasure, coldPreviousMeasure, inRate+outRate);
        double hotSum = measureCalculator.calculate(hotCurrentMeasure, hotPreviousMeasure, outRate);
        return coldSum+hotSum;
    }
}
