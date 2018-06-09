package ru.rrozhkov.easykin.model;

import ru.rrozhkov.easykin.core.filter.IFilterBean;

/**
 * Created by rrozhkov on 15.05.2018.
 */
public abstract class FilterBean implements IFilterBean {
    private String moduleId;
    private String subModuleId;

    public FilterBean(String moduleId) {
        this.moduleId = moduleId;
    }
    public FilterBean(String moduleId, String subModuleId) {
        this.moduleId = moduleId;
        this.subModuleId = subModuleId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getSubModuleId() {
        return subModuleId;
    }

    public void setSubModuleId(String subModuleId) {
        this.subModuleId = subModuleId;
    }
}
