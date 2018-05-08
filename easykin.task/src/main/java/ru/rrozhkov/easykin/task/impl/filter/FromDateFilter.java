package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.filter.IFilter;

import java.util.Date;

/**
 * Created by rrozhkov on 08.05.2018.
 */
public class FromDateFilter implements IFilter<ITask> {
    private Date date;
    protected FromDateFilter(Date date) {this.date = date;}
    public boolean filter(ITask obj) {return obj.getPlanDate().getTime()>=date.getTime();}
}
