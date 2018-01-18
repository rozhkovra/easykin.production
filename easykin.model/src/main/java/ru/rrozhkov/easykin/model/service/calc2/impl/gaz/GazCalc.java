package ru.rrozhkov.easykin.model.service.calc2.impl.gaz;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class GazCalc extends MeasureCalc{
    public GazCalc(Collection<IMeasure> oldMeasures, Collection<IMeasure> newMeasures, Money rate, boolean isPaid) {
        super(CalculationType.GAZ,oldMeasures, newMeasures, rate, isPaid);
    }
}