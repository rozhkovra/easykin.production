package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Reading implements IReading {
    protected int id;
    protected Date date;
    protected Collection<IMeasure> measures;

    public Reading(int id, Date date) {
        this(id,date, CollectionUtil.<IMeasure>create());
    }

    public Reading(Date date, Collection<IMeasure> measures) {
        this(-1, date,measures);
    }

    public Reading(int id, Date date, Collection<IMeasure> measures) {
        this.id = id;
        this.date = date;
        this.measures = measures;
    }

    public Date getDate() {
        return date;
    }

    public Collection<IMeasure> getMeasures() {
        return measures;
    }

    public int getId() {
        return id;
    }

    @Override
    public Reading clone() throws CloneNotSupportedException {
        Reading reading = (Reading)super.clone();
        reading.setId(-1);
        Collection<IMeasure> newMeasures = CollectionUtil.create();
        for(IMeasure measure : measures) {
            IMeasure newMeasure = (IMeasure)((Measure)measure).clone();
            newMeasures.add(newMeasure);
        }
        reading.setMeasures(newMeasures);
        return reading;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMeasures(Collection<IMeasure> measures) {
        this.measures = measures;
    }
}
