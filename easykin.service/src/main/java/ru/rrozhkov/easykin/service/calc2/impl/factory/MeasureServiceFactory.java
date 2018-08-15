package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.service.calc2.impl.builder.Calc2Builder;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.ICalc2Bean;
import ru.rrozhkov.easykin.service.calc2.impl.calculator.MeasureCalculatorAdapter;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class MeasureServiceFactory extends AbstractService2Factory {
    @Override
    public ICalculation buildCalculation(ICalcBean bean) {
        return new Calc2Builder((ICalc2Bean)bean, new MeasureCalculatorAdapter(bean)).build();
    }
}
