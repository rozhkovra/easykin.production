package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Measure implements IMeasure{
    protected IReading reading;
    protected MeasureType type;
    protected Object value;

    public Measure(IReading reading, MeasureType type, Object value) {
        this.reading = reading;
        this.type = type;
        this.value = value;
    }

    public IReading getReading() {
        return reading;
    }

    public MeasureType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }
}
