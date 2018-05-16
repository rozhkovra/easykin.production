package ru.rrozhkov.easykin.model;

import ru.rrozhkov.lib.filter.IFilterBean;

/**
 * Created by rrozhkov on 15.05.2018.
 */
public abstract class FilterBean implements IFilterBean {
    private String moduleId;

    public FilterBean(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
}
