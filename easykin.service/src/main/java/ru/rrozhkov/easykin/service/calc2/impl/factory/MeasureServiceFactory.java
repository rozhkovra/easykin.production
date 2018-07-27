package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc2.impl.builder.MeasureCalcBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.MeasureCalculatorAdapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class MeasureServiceFactory extends AbstractService2Factory {
    @Override
    public ICalculation buildCalculation(ICalcBuildBean bean) {
        return new MeasureCalcBuilder(bean).build();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new MeasureCalculatorAdapter(calculation);
    }

}
