package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.service.calc.impl.builder.CalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.calculator.MeasureCalculatorAdapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class MeasureServiceFactory extends AbstractServiceFactory {
    @Override
    public ICalculation buildCalculation(ICalcBean bean) {
        return new CalcBuilder(bean, new MeasureCalculatorAdapter(bean)).build();
    }
}
