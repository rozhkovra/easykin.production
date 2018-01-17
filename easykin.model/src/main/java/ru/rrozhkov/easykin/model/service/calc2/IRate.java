package ru.rrozhkov.easykin.model.service.calc2;

import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public interface IRate {
    int getId();
    RateType getType();
    Object getValue();
    Date getDateFrom();
    Date getDateTo();
}
