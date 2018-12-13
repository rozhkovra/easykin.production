package ru.rrozhkov.easykin.work.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 1/16/2018.
 */
public class ActivityBuilder {
    private static final WorkFactory workFactory = WorkFactory.instance();

    private static class Holder {
        private static final ActivityBuilder INSTANCE = new ActivityBuilder();
    }

    public static ActivityBuilder instance(){
        return Holder.INSTANCE;
    }

    private ActivityBuilder() {
    }

    public Collection<IActivity> build(final IPerson person, final Collection<IActivity> activities) {
        Collection<IActivity> collection = CollectionUtil.create();
        for(IActivity activity : activities) {
            collection.add(applyPerson(activity, person));
        }
        return collection;
    }

    private IActivity applyPerson(IActivity activity, final IPerson person ){
        if(activity.getPerson()==null) {
            activity = workFactory.create(activity.getId(),activity.getDate(),person,activity.getTime(),activity.getTaskType(),activity.getName(),activity.getReleaseType(),activity.getDesc());
        }
        return activity;
    }

}
