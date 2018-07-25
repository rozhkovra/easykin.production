package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ElectricityCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;

import java.util.Collection;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class ElectricityCalcBuilder implements ICalcBuilder {
    private IReading oldReading;
    private IReading newReading;
    private Collection<IRate> rates;

    public ElectricityCalcBuilder() {
    }

    public void init(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        this.oldReading = oldReading;
        this.newReading = newReading;
        this.rates = rates;
    }

    public ICalculation build() {
        Money electricityRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(oldReading).getMeasuresByType(MeasureType.ELECTRICITY);
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(newReading).getMeasuresByType(MeasureType.ELECTRICITY);

        for(IRate rate : rates) {
            if(rate.getType().isElectricity()) {
                electricityRate = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.ELECTRICITY);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new ElectricityCalc(calcId, newReading.getId(), oldMeasures, newMeasures, electricityRate, isPaid);
    }
}
