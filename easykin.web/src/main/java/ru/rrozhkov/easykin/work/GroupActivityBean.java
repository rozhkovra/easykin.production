package ru.rrozhkov.easykin.work;

/**
 * Created by rrozhkov on 09.06.2018.
 */
public class GroupActivityBean {
    private int num;
    private String name;
    private int time;

    public GroupActivityBean(int num, String name, int time) {
        this.num = num;
        this.name = name;
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
