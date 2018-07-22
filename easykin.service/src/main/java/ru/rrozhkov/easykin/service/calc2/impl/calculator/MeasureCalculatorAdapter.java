package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureCalculatorAdapter extends Calculator {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();
    private static final MeasureCalculator measureCalculator = new MeasureCalculator();

    public MeasureCalculatorAdapter(MeasureCalc calc) {
        super(calc);
    }

    public IResult calculate() {
        MeasureCalc mCalc = (MeasureCalc)getCalc();
        int curr = CalcUtil.summ(mCalc.getNewMeasures());
        int prev = CalcUtil.summ(mCalc.getOldMeasures());
        int delta = curr-prev;
        double rate = mCalc.getRatePrice().getValue();
        Money sum = Money.valueOf(measureCalculator.calculate(curr, prev, rate));
        return serviceFactory.createMeasureResult(delta, sum, sum);
    }
}
