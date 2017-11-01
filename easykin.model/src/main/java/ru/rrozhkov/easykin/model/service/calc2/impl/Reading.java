package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Reading implements IReading {
    protected Date date;
    protected Collection<IMeasure> measures;

    public Reading(Date date, Collection<IMeasure> measures) {
        this.date = date;
        this.measures = measures;
    }

    public Date getDate() {
        return date;
    }

    public Collection<IMeasure> getMeasures() {
        return measures;
    }
}
