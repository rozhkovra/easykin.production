package ru.rrozhkov.easykin.work.service.impl;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.db.impl.ActivityHandler;
import ru.rrozhkov.easykin.core.db.IEntityHandler;
import ru.rrozhkov.easykin.work.impl.ActivityBuilder;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class ActivityService {
    private static final IEntityHandler activityHandler = ActivityHandler.instance();
    private static ActivityBuilder activityBuilder = ActivityBuilder.instance();

    private static class Holder {
        private static final ActivityService INSTANCE = new ActivityService();
    }

    public static ActivityService instance(){
        return Holder.INSTANCE;
    }

    private ActivityService() {
    }

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

    public Collection activities() {
        return activityBuilder.build();
    }
}
