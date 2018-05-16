package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.model.work.IActivity;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ActivityBean {
    private int num;
    private IActivity activity;
    private String dateClass;

    public ActivityBean(int num, IActivity activity, String dateClass) {
        this.num = num;
        this.activity = activity;
        this.dateClass = dateClass;
    }

    public IActivity getActivity() {
        return activity;
    }

    public void setActivity(IActivity activity) {
        this.activity = activity;
    }

    public String getDateClass() {
        return dateClass;
    }

    public void setDateClass(String dateClass) {
        this.dateClass = dateClass;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
