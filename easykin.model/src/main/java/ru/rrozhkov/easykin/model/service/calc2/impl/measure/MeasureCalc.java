package ru.rrozhkov.easykin.model.service.calc2.impl.measure;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;

import java.util.Collection;

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

    public Collection<IMeasure> getOldMeasures() {
        return oldMeasures;
    }

    public Collection<IMeasure> getNewMeasures() {
        return newMeasures;
    }
}
