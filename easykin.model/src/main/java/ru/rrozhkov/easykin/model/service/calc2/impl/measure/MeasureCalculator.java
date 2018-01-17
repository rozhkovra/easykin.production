package ru.rrozhkov.easykin.model.service.calc2.impl.measure;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculator;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureCalculator extends Calculator {
    public MeasureCalculator(MeasureCalc calc) {
        super(calc);
    }

    public IResult calculate() {
        MeasureCalc mCalc = (MeasureCalc)getCalc();
        int curr = 0;
        int prev = 0;
        for(IMeasure measure : mCalc.getOldMeasures()) {
            prev += (Integer)measure.getValue();
        }
        for(IMeasure measure : mCalc.getNewMeasures()) {
            curr += (Integer)measure.getValue();
        }
        int delta = curr-prev;
        Money deltaSum = MoneyFactory.create(mCalc.getPrice()).multiply(delta);
        return new MeasureResult(delta, deltaSum, deltaSum);
    }
}
