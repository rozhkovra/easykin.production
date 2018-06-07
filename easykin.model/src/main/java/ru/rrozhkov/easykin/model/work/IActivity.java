package ru.rrozhkov.easykin.model.work;

import ru.rrozhkov.lib.db.IEntity;
import ru.rrozhkov.easykin.model.person.IPerson;

import java.util.Date;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public interface IActivity extends IEntity {
    Date getDate();
    IPerson getPerson();
    int getTime();
    TaskType getTaskType();
    String getName();
    ReleaseType getReleaseType();
    String getDesc();

    int getId();
}
