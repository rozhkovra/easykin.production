package ru.rrozhkov.easykin.work.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.db.impl.ActivityHandler;
import ru.rrozhkov.easykin.work.impl.ActivityBuilder;

import java.util.Collection;

/**
 * Created by rrozhkov on 06.06.2018.
 */
public class ActivityService extends EntityService {
    private static final ActivityHandler activityHandler = ActivityHandler.instance();
    private static ActivityBuilder activityBuilder = ActivityBuilder.instance();

    private static class Holder {
        private static final ActivityService INSTANCE = new ActivityService();
    }

    public static ActivityService instance(){
        return Holder.INSTANCE;
    }

    private ActivityService() {
        super(activityHandler);
    }

    public Collection activities(final IPerson person) {
        Collection<IActivity> activities = CollectionUtil.create();
        try{
            activities = activityHandler.selectForPerson(person.getId());
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return activityBuilder.build(person, activities);
    }
}
