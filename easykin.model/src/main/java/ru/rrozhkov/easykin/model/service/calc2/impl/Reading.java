package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Reading implements IReading {
    protected int id;
    protected Date date;
    protected Collection<IMeasure> measures;
    protected Collection<ICalculation> calcs;

    public Reading(int id, Date date) {
        this(id, date, CollectionUtil.<IMeasure>create(), CollectionUtil.<ICalculation>create());
    }

    public Reading(Date date, Collection<IMeasure> measures) {
        this(-1, date, measures, CollectionUtil.<ICalculation>create());
    }

    public Reading(int id, Date date, Collection<IMeasure> measures, Collection<ICalculation> calcs) {
        this.id = id;
        this.date = date;
        this.measures = measures;
        this.calcs = calcs;
    }

    public Date getDate() {
        return date;
    }

    public Collection<IMeasure> getMeasures() {
        return measures;
    }

    public Collection<ICalculation> getCalcs() {
        return calcs;
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
            IMeasure newMeasure = ((Measure)measure).clone();
            newMeasures.add(newMeasure);
        }
        reading.setMeasures(newMeasures);
        Collection<ICalculation> newCalcs = CollectionUtil.create();
/*        for(ICalculation calculation : calcs) {
            ICalculation newCalculation = ((Calculation)calculation).clone();
            newCalcs.add(newCalculation);
        }
*/
        reading.setCalcs(newCalcs);
        reading.setMeasures(newMeasures);
        return reading;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMeasures(Collection<IMeasure> measures) {
        this.measures = measures;
    }

    public void setCalcs(Collection<ICalculation> calcs) {
        this.calcs = calcs;
    }
}
