package ru.rrozhkov.easykin.work.service.impl;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.db.impl.ActivityHandler;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class ActivityService {
    private static final ActivityHandler activityHandler = new ActivityHandler();

    public int createOrUpdate(IActivity activity){
        int activityId = activity.getId();
        try{
            if(activityId==-1) {
                activityId = activityHandler.insert(activity);
            }else {
                activityHandler.update(activity);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return activityId;
    }

}
