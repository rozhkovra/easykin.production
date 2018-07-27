package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.builder.DefaultCalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.DefaultCalculator;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class DefaultServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalculation buildCalculation(ICalcBuildBean bean) {
        return new DefaultCalcBuilder(bean).build();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new DefaultCalculator(calculation);
    }
}
