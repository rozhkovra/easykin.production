package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.DefaultResult;
import ru.rrozhkov.easykin.model.service.calc.impl.WaterCalc;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public abstract class AbstractServiceFactory {
    public static AbstractServiceFactory instance(Class clazz) {
        if (clazz.equals(ServiceCalc.class)) {
            return new AllServiceFactory();
        }
        if (clazz.equals(WaterCalc.class)) {
            return new WaterServiceFactory();
        }
        if (clazz.equals(MeasureCalc.class)) {
            return new MeasureServiceFactory();
        }
        return new DefaultServiceFactory();
    }

    public static AbstractServiceFactory defaultInstance() {
        return new DefaultServiceFactory();
    }
    public abstract ICalculation buildCalculation(ICalcBuildBean bean);
    public abstract ICalculator getCalculator(ICalculation calculation);
    public IResult getResult(Money sum) {
        return new DefaultResult(sum);
    };
}
