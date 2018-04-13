package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.IResult;
import ru.rrozhkov.easykin.model.service.calc2.*;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureResult;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class ServiceFactory {
    public static IReading createReading(int id, Date date){
        return new Reading(id, date);
    }
    public static IReading createReading(int id, Date date, Collection<IMeasure> measures){
        return new Reading(id, date, measures);
    }
    public static IMeasure createMeasure(int id, int readingId, MeasureType type, Object value){
        return new Measure(id, readingId, type, value);
    }
    public static IResult createMeasureResult(double delta, Money deltaSum, Money sum){
        return new MeasureResult(delta, deltaSum, sum);
    }
    public static IRate createRate(int id, RateType type, Object value, Date dateFrom, Date dateTo){
        return new Rate(id, type, Money.valueOf(value), dateFrom, dateTo);
    }
}
