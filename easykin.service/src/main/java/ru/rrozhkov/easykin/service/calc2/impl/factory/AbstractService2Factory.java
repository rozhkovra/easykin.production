package ru.rrozhkov.easykin.service.calc2.impl.factory;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public abstract class AbstractService2Factory extends AbstractServiceFactory {
    public static AbstractService2Factory instance(CalculationType type) {
        if (type.isWater()) {
            return new WaterServiceFactory();
        }
        if (type.isHotWater() || type.isElectricity()) {
            return new MeasureServiceFactory();
        }
        return new RateServiceFactory();
    }
}
