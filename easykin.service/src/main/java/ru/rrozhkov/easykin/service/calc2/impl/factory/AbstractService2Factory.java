package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.model.service.calc2.impl.MeasureCalc;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public abstract class AbstractService2Factory extends AbstractServiceFactory {
    public static AbstractService2Factory instance(Class clazz) {
        if (clazz.equals(WaterCalc2.class)) {
            return new WaterServiceFactory();
        }
        if (clazz.equals(MeasureCalc.class)) {
            return new MeasureServiceFactory();
        }
        return new RateServiceFactory();
    }
}
