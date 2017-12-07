package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.RateType;

import java.util.Date;

/**
 * Created by rrozhkov on 11/1/2017.
 */
public class Rate implements IRate {
    protected RateType type;
    protected Object value;
    protected Date dateFrom;
    protected Date dateTo;

    public Rate(RateType type, Object value, Date dateFrom, Date dateTo) {
        this.type = type;
        this.value = value;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public RateType getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }
}