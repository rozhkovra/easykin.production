package ru.rrozhkov.easykin.model.service.calc2;

import ru.rrozhkov.easykin.core.db.IEntity;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public interface IReading extends Cloneable, IEntity{
    int getId();
    Date getDate();
    Collection<IMeasure> getMeasures();
    Collection<ICalculation> getCalcs();
}
