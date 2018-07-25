package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.calc.impl.builder.GazCalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.GazCalculator;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class GazServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalcBuilder getCalcBuilder() {
        return new GazCalcBuilder();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new GazCalculator(calculation);
    }
}
