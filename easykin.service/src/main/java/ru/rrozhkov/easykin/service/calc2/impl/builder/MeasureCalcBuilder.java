package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.*;
import ru.rrozhkov.easykin.model.service.calc2.impl.HotWaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;

import java.util.Collection;

/**
 * Created by rrozhkov on 25.07.2018.
 */
public class MeasureCalcBuilder implements ICalcBuilder {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();
    private IReading oldReading;
    private IReading newReading;
    private Collection<IRate> rates;
    private CalculationType type;

    public MeasureCalcBuilder() {
    }

    public void init(IReading oldReading, IReading newReading, Collection<IRate> rates, CalculationType type) {
        this.oldReading = oldReading;
        this.newReading = newReading;
        this.rates = rates;
        this.type = type;
    }

    public ICalculation build() {
        Money hotRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(oldReading).getMeasuresByType(typeResolver.measure(type));
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(newReading).getMeasuresByType(typeResolver.measure(type));
        for(IRate rate : rates) {
            if(rate.getType().equals(typeResolver.rate(type))) {
                hotRate = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), type);
            isPaid = calc != null && calc.isPaid();
            calcId = calc.getId();
        }
        return new MeasureCalc(calcId, newReading.getId(), type, hotRate, isPaid, oldMeasures, newMeasures);
    }
}
