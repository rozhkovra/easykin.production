package ru.rrozhkov.easykin.model.task;

import ru.rrozhkov.lib.db.IEntity;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public interface ITask2Payment extends IEntity {
    int getId();
    int getPaymentId();
    int getTaskId();
}
