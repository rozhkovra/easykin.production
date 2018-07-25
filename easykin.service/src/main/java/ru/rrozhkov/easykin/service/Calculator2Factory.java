package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.MeasureCalculatorAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.WaterCalculator2Adapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class Calculator2Factory extends CalculatorFactory {
    protected Calculator2Factory() {
    }

    public ICalculator getCalculator(ICalculation bean){
        if (bean instanceof WaterCalc2)
            return new WaterCalculator2Adapter(bean);
        else if (bean instanceof MeasureCalc)
            return new MeasureCalculatorAdapter(bean);
        return super.getCalculator(bean);
    }
}
