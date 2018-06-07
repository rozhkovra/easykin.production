package ru.rrozhkov.easykin.model.task;

import ru.rrozhkov.lib.db.IEntity;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public interface ITask2Person extends IEntity {
    int getId();
    int getPersonId();
    int getTaskId();
}
