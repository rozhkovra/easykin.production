package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.WaterCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.WaterCalculatorAdapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalcBuilder getCalcBuilder() {
        return new WaterCalcBuilder();
    }

    @Override
    public ICalculator getCalculator(ICalculation calc) {
        return new WaterCalculatorAdapter(calc);
    }
}
