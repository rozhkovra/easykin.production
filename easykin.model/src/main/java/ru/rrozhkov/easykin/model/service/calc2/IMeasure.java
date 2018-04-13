package ru.rrozhkov.easykin.model.service.calc2;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public interface IMeasure extends Cloneable{
    int getId();
    int getReadingId();
    Object getValue();
    MeasureType getType();
}
