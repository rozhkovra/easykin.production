package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.model.task.ITask2Person;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class Task2Person implements ITask2Person {
    protected int id;
    protected int personId;
    protected int taskId;

    public Task2Person(int id, int personId, int taskId) {
        this.id = id;
        this.personId = personId;
        this.taskId = taskId;
    }

    public int getId() {
        return id;
    }

    public int getPersonId() {
        return personId;
    }

    public int getTaskId() {
        return taskId;
    }
}
