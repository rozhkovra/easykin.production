package ru.rrozhkov.easykin.model.work.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;

import java.util.Date;

/**
 * Created by rrozhkov on 1/15/2018.
 */
public class Activity implements IActivity{
    protected int id;
    protected Date date;
    protected IPerson person;
    protected int time;
    protected TaskType taskType;
    protected String name;
    protected ReleaseType releaseType;
    protected String desc;

    public Activity(int id, Date date, IPerson person, int time, TaskType taskType, String name, ReleaseType releaseType, String desc) {
        this.id = id;
        this.date = date;
        this.person = person;
        this.time = time;
        this.taskType = taskType;
        this.name = name;
        this.releaseType = releaseType;
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public IPerson getPerson() {
        return person;
    }

    public int getTime() {
        return time;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getName() {
        return name;
    }

    public ReleaseType getReleaseType() {
        return releaseType;
    }

    public String getDesc() {
        return desc;
    }

    public int getId() {
        return id;
    }
}
