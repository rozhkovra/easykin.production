package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.ServiceCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.ServiceCalculator;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class AllServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalcBuilder getCalcBuilder() {
        return new ServiceCalcBuilder();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new ServiceCalculator(calculation);
    }

}
