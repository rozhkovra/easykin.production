package ru.rrozhkov.easykin.model.service.calc2;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public interface IReading<T> {
    Date getDate();
    Collection<T> getMeasures();
}
