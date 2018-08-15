package ru.rrozhkov.easykin.service.calculator;

import ru.rrozhkov.easykin.core.calculation.ICalculator;
import ru.rrozhkov.easykin.core.calculation.IResult;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class WaterCalculator implements ICalculator {
    private double inRate;
    private double outRate;
    private int coldCurrentMeasure;
    private int coldPreviousMeasure;
    private int hotCurrentMeasure;
    private int hotPreviousMeasure;

    public WaterCalculator(double inRate, double outRate, int coldCurrentMeasure, int coldPreviousMeasure, int hotCurrentMeasure, int hotPreviousMeasure) {
        this.inRate = inRate;
        this.outRate = outRate;
        this.coldCurrentMeasure = coldCurrentMeasure;
        this.coldPreviousMeasure = coldPreviousMeasure;
        this.hotCurrentMeasure = hotCurrentMeasure;
        this.hotPreviousMeasure = hotPreviousMeasure;
    }

    public IResult calculate() {
        MeasureCalculator measureCalculator = new MeasureCalculator(coldCurrentMeasure, coldPreviousMeasure, inRate+outRate);
        double coldSum = (Double)measureCalculator.calculate().getResult();
        measureCalculator = new MeasureCalculator(hotCurrentMeasure, hotPreviousMeasure, outRate);
        double hotSum = (Double)measureCalculator.calculate().getResult();
        return new CalcResult(coldSum+hotSum);
    }
}
