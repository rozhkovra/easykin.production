package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Measure implements IMeasure {
    protected int id;
    protected int readingId;
    protected MeasureType type;
    protected Object value;

    public Measure(MeasureType type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Measure(int id, int readingId, MeasureType type, Object value) {
        this(type, value);
        this.id = id;
        this.readingId = readingId;
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

    public int getId() {
        return id;
    }

    public int getReadingId() {
        return readingId;
    }

    @Override
    public Measure clone() throws CloneNotSupportedException {
        Measure measure = (Measure)super.clone();
        measure.setId(-1);
        return measure;
    }

    public void setId(int id) {
        this.id = id;
    }
}
