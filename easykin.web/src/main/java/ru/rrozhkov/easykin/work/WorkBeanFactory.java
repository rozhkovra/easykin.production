package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.model.work.IActivity;

/**
 * Created by rrozhkov on 04.06.2018.
 */
public class WorkBeanFactory {
    public ActivityBean activityBean(int num, IActivity activity, String dateClass) {
        return new ActivityBean(num, activity, dateClass);
    }
}
