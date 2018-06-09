package ru.rrozhkov.easykin.model.service.calc2;

import ru.rrozhkov.easykin.core.db.IEntity;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public interface IMeasure extends Cloneable, IEntity{
    int getId();
    int getReadingId();
    Object getValue();
    MeasureType getType();
}
