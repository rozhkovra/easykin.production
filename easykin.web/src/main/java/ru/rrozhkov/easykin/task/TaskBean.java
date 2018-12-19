package ru.rrozhkov.easykin.task;

import ru.rrozhkov.easykin.model.task.ITask;

/**
 * Created by rrozhkov on 11.05.2018.
 */
public class TaskBean {
    private int num;
    private ITask task;
    private String taskClass = "";
    private String dateClass = "";
    private String comments = "";
    private String taskCloseId = "";

    public TaskBean(int num, ITask task, String taskClass, String dateClass, String comments, String taskCloseId) {
        this.num = num;
        this.task = task;
        this.taskClass = taskClass;
        this.dateClass = dateClass;
        this.comments = comments;
        this.taskCloseId = taskCloseId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public ITask getTask() {
        return task;
    }

    public void setTask(ITask task) {
        this.task = task;
    }

    public String getTaskClass() {
        return taskClass;
    }

    public void setTaskClass(String taskClass) {
        this.taskClass = taskClass;
    }

    public String getDateClass() {
        return dateClass;
    }

    public void setDateClass(String dateClass) {
        this.dateClass = dateClass;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTaskCloseId() {
        return taskCloseId;
    }

    public void setTaskCloseId(String taskCloseId) {
        this.taskCloseId = taskCloseId;
    }
}
