package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureCalc extends RateCalc {
    Collection<IMeasure> oldMeasures;
    Collection<IMeasure> newMeasures;

    public MeasureCalc(CalculationType type, Collection<IMeasure> oldMeasures,Collection<IMeasure> newMeasures, Money rate, boolean isPaid) {
        super(type, rate, isPaid);
        this.oldMeasures = oldMeasures;
        this.newMeasures = newMeasures;
    }

    public MeasureCalc(int id, int readingId, CalculationType type, Money rate, boolean isPaid, Collection<IMeasure> oldMeasures, Collection<IMeasure> newMeasures) {
        super(id, readingId, type, rate, isPaid);
        this.oldMeasures = oldMeasures;
        this.newMeasures = newMeasures;
    }

    public MeasureCalc(int id, int readingId, CalculationType type, Map<RateType, Money> rates, boolean isPaid, Collection<IMeasure> oldMeasures, Collection<IMeasure> newMeasures) {
        super(id, readingId, type, rates, isPaid);
        this.oldMeasures = oldMeasures;
        this.newMeasures = newMeasures;
    }

    public Collection<IMeasure> getOldMeasures() {
        return oldMeasures;
    }

    public Collection<IMeasure> getNewMeasures() {
        return newMeasures;
    }
}
