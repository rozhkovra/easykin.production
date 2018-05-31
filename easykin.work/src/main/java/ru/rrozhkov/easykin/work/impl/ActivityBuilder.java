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
    public IActivity build(IActivity activity){
        //todo add handle of person from db
        IPerson person = AuthManager.instance().signedPerson();
        if(activity.getPerson()==null) {
            activity = WorkFactory.create(activity.getId(),activity.getDate(),person,activity.getTime(),activity.getTaskType(),activity.getName(),activity.getReleaseType(),activity.getDesc());
        }
        return activity;
    }

    public Collection<IActivity> build() {
        IPerson person = AuthManager.instance().signedPerson();
        Collection<IActivity> collection = CollectionUtil.create();
        try {
            Collection<IActivity> activities = ActivityHandler.selectForPerson(person.getId());
            for(IActivity activity : activities) {
                collection.add(build(activity));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }
}
