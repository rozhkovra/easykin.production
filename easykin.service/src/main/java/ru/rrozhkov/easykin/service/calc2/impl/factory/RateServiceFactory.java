package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.calculator.DefaultCalculator;
import ru.rrozhkov.easykin.service.calc2.impl.builder.RateCalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class RateServiceFactory extends AbstractService2Factory {
    @Override
    public ICalculation buildCalculation(ICalcBuildBean bean) {
        return new RateCalcBuilder(bean).build();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new DefaultCalculator(calculation);
    }
}
