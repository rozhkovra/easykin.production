package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class WaterCalc extends MeasureCalc {
    public WaterCalc(int id, int readingId, CalculationType type, Map<RateType, Money> rates, boolean isPaid, Collection<IMeasure> oldMeasures, Collection<IMeasure> newMeasures) {
        super(id, readingId, type, rates, isPaid, oldMeasures, newMeasures);
    }
}
