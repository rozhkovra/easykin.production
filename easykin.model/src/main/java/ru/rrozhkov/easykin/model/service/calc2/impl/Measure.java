package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Measure implements IMeasure{
    protected MeasureType type;
    protected Object value;

    public Measure(MeasureType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public MeasureType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
