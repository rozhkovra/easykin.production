package ru.rrozhkov.easykin.model.work;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public interface ITimesheet {
    String getName();
    Collection<IActivity> getActivities();
}
