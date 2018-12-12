package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc2.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ServiceFactory {
    private static final int VERSION = 2;
    private static class Holder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceFactory() {
    }

    public IReading createReading(int id, Date date){
        return new Reading(id, date);
    }
    public IReading createReading(int id, Date date, Collection<IMeasure> measures, Collection<ICalculation> calcs){
        return new Reading(id, date, measures, calcs);
    }
    public IMeasure createMeasure(int id, int readingId, MeasureType type, Object value){
        return new Measure(id, readingId, type, value);
    }
    public IMeasure createMeasure(MeasureType type, Object value){
        return new Measure(type, value);
    }
    public IRate createRate(int id, RateType type, Object value, Date dateFrom, Date dateTo){
        return new Rate(id, type, Money.valueOf(value), dateFrom, dateTo);
    }
    public ICalculation createCalc(int id, int readingId, CalculationType type, boolean isPaid, Money amount){
        return new Calculation(id, readingId, type, isPaid, amount, VERSION);
    }
}
