package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc2.impl.builder.WaterCalcBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.WaterCalculator2Adapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterServiceFactory extends AbstractService2Factory {
    @Override
    public ICalculation buildCalculation(ICalcBuildBean bean) {
        return new WaterCalcBuilder(bean).build();
    }

    @Override
    public ICalculator getCalculator(ICalculation calc) {
        return new WaterCalculator2Adapter(calc);
    }
}
