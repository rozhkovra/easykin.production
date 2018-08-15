package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.service.calc.impl.builder.ServiceCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.ServiceCalcCalculator;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class AllServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalculation buildCalculation(ICalcBean bean) {
        return new ServiceCalcBuilder(bean, new ServiceCalcCalculator(bean)).build();
    }
}
