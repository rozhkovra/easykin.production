package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.ServiceTypeResolver;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class RateCalcBuilder implements ICalcBuilder {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();
    private IReading newReading;
    private Collection<IRate> rates;
    private CalculationType type;

    public RateCalcBuilder() {
    }

    public void init(IReading newReading, Collection<IRate> rates, CalculationType type) {
        this.newReading = newReading;
        this.rates = rates;
        this.type = type;
    }

    public ICalculation build() {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().equals(typeResolver.rate(type))) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), type);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), type, money, isPaid);
    }
}
