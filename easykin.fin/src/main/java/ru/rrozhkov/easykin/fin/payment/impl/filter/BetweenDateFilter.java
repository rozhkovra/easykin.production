package ru.rrozhkov.easykin.fin.payment.impl.filter;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

import java.util.Date;

/**
 * Created by rrozhkov on 03.07.2018.
 */
public class BetweenDateFilter implements IFilter<IPayment> {
    private Date start;
    private Date end;

    public BetweenDateFilter(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public boolean filter(IPayment obj) {
        return obj.getDate().getTime() > start.getTime() && obj.getDate().getTime() < end.getTime();
    }
}
