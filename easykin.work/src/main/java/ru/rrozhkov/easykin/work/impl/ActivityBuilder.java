package ru.rrozhkov.easykin.work.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.easykin.person.auth.AuthManager;
import ru.rrozhkov.easykin.work.db.impl.ActivityHandler;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/16/2018.
 */
public class ActivityBuilder {
    private static final WorkFactory workFactory = WorkFactory.instance();
    private static final ActivityHandler activityHandler = new ActivityHandler();
    private static final AuthManager authManager = AuthManager.instance();

    public IActivity applyPerson(IActivity activity){
        IPerson person = authManager.signedPerson();
        if(activity.getPerson()==null) {
            activity = workFactory.create(activity.getId(),activity.getDate(),person,activity.getTime(),activity.getTaskType(),activity.getName(),activity.getReleaseType(),activity.getDesc());
        }
        return activity;
    }

    public Collection<IActivity> build() {
        IPerson person = authManager.signedPerson();
        Collection<IActivity> collection = CollectionUtil.create();
        try {
            Collection<IActivity> activities = activityHandler.selectForPerson(person.getId());
            for(IActivity activity : activities) {
                collection.add(applyPerson(activity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }
}
