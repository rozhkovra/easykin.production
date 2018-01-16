package ru.rrozhkov.easykin.model.work.impl;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ITimesheet;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public class Timesheet implements ITimesheet {
    protected String name;
    protected Collection<IActivity> activities;

    public Timesheet(String name, Collection<IActivity> activities) {
        this.name = name;
        this.activities = activities;
    }

    public String getName() {
        return name;
    }

    public Collection<IActivity> getActivities() {
        return activities;
    }
}
