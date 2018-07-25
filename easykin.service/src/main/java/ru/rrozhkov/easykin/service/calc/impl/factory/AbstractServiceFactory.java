package ru.rrozhkov.easykin.service.calc.impl.factory;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultResult;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public abstract class AbstractServiceFactory {
    public static AbstractServiceFactory instance(CalculationType type) {
        if (type.isWater()) {
            return new WaterServiceFactory();
        }
        if (type.isElectricity()) {
            return new ElectricityServiceFactory();
        }
        if (type.isHotWater()) {
            return new HotWaterServiceFactory();
        }
        if (type.isGaz()) {
            return new GazServiceFactory();
        }
        return new DefaultServiceFactory();
    }

    public static AbstractServiceFactory defaultInstance() {
        return new DefaultServiceFactory();
    }

    public abstract ICalcBuilder getCalcBuilder();
    public abstract ICalculator getCalculator(ICalculation calculation);
    public IResult getResult(Money sum) {
        return new DefaultResult(sum);
    };
}
