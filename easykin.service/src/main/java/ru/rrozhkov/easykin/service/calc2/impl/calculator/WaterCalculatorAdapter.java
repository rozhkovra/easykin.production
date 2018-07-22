package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.calculator.WaterCalculator;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class WaterCalculatorAdapter extends MeasureCalculatorAdapter {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();
    private static final WaterCalculator waterCalculator = new WaterCalculator();

    public WaterCalculatorAdapter(MeasureCalc calc) {
        super(calc);
    }

    @Override
    public IResult calculate() {
        MeasureCalc mCalc = (MeasureCalc)getCalc();
        Money rateIn = mCalc.getRates().get(RateType.WATERIN);
        Money rateOut = mCalc.getRates().get(RateType.WATEROUT);
        int currCold = CalcUtil.summ(mCalc.getNewMeasures(), MeasureType.COLDWATER);
        int prevCold = CalcUtil.summ(mCalc.getOldMeasures(), MeasureType.COLDWATER);
        int currHot = CalcUtil.summ(mCalc.getNewMeasures(), MeasureType.HOTWATER);
        int prevHot = CalcUtil.summ(mCalc.getOldMeasures(), MeasureType.HOTWATER);
        double result = waterCalculator.calculate(rateIn.getValue(), rateOut.getValue(), currCold, prevCold, currHot, prevHot);
        Money sum = Money.valueOf(result);
        return serviceFactory.createMeasureResult(0, sum, sum);
    }
}
