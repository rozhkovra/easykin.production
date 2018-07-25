package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.calc.impl.builder.HotWaterCalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.HotWaterCalculator;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class HotWaterServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalcBuilder getCalcBuilder() {
        return new HotWaterCalcBuilder();
    }

    @Override
    public ICalculator getCalculator(ICalculation calculation) {
        return new HotWaterCalculator(calculation);
    }

}
