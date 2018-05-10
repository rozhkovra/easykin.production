package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.lib.filter.IFilterBean;

import java.util.Date;

/**
 * Created by rrozhkov on 10.05.2018.
 */
public class TaskFilterBean implements IFilterBean {
    private int statusId;
    private int categoryId;
    private int priorityId;
    private Date fromDate;
    private Date toDate;
    private int personId;

    public TaskFilterBean(int statusId, int categoryId, int priorityId, Date fromDate, Date toDate, int personId) {
        this.statusId = statusId;
        this.categoryId = categoryId;
        this.priorityId = priorityId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.personId = personId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriority(int priorityId) {
        this.priorityId = priorityId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
}
