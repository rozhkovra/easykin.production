package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class WorkAdapter {
    private static final WorkBeanFactory workBeanFactory = new WorkBeanFactory();

    public Collection<ActivityBean> activities() {
        Collection<ActivityBean> beans = CollectionUtil.create();
        Collection<IActivity> activities = Module.activities();
        Map<Date, Integer> dayTime = new HashMap<Date, Integer>();
        for(IActivity activity : activities){
            int curTime = activity.getTime();
            if (dayTime.containsKey(activity.getDate())) {
                curTime += dayTime.get(activity.getDate());
            }
            dayTime.put(activity.getDate(), curTime);
        }
        int i = 0;
        for(IActivity activity : activities) {
            if (Integer.valueOf(8).equals(dayTime.get(activity.getDate()))) {
                beans.add(workBeanFactory.activityBean(++i, activity, "label bg-green"));
            } else {
                beans.add(workBeanFactory.activityBean(++i, activity,"label bg-yellow"));
            }
        }
        return beans;
    }
}
