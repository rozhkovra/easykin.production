package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.calc2.impl.factory.AbstractService2Factory;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class Calculator2Factory extends CalculatorFactory {
    public static CalculatorAbstractFactory instance() {
        return new Calculator2Factory();
    }

    protected Calculator2Factory() {
    }

    public ICalculator getCalculator(ICalculation bean){
        if (bean.getVersion()==2) {
            return AbstractService2Factory.instance(bean.getClass()).getCalculator(bean);
        }
        return super.getCalculator(bean);
    }
}
