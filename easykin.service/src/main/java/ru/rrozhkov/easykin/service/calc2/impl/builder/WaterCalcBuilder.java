package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.*;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterCalcBuilder implements ICalcBuilder {
    private IReading oldReading;
    private IReading newReading;
    private Collection<IRate> rates;

    public WaterCalcBuilder() {
    }

    public void init(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        this.oldReading = oldReading;
        this.newReading = newReading;
        this.rates = rates;
    }

    public ICalculation build() {
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(oldReading).getMeasuresByType(MeasureType.COLDWATER);
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(newReading).getMeasuresByType(MeasureType.COLDWATER);
        oldMeasures.addAll(ReadingMeasureAdapter.create(oldReading).getMeasuresByType(MeasureType.HOTWATER));
        newMeasures.addAll(ReadingMeasureAdapter.create(newReading).getMeasuresByType(MeasureType.HOTWATER));
        Map<RateType, Money> mapRates = CollectionUtil.map();
        for(IRate rate : rates) {
            if(rate.getType().isWaterIn()) {
                mapRates.put(rate.getType(),Money.valueOf(rate.getValue()));
            } else if(rate.getType().isWaterOut()) {
                mapRates.put(rate.getType(),Money.valueOf(rate.getValue()));
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.WATER);
            isPaid = calc != null && calc.isPaid();
            calcId = calc.getId();
        }
        return new WaterCalc2(calcId, newReading.getId(), CalculationType.WATER, mapRates, isPaid, oldMeasures, newMeasures);
    }
}
