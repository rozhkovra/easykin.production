package ru.rrozhkov.easykin.service;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public abstract class CalcBuilder implements ICalcBuilder {
    ICalcBuildBean buildBean;

    public CalcBuilder(ICalcBuildBean buildBean) {
        this.buildBean = buildBean;
    }

    public ICalcBuildBean getBuildBean() {
        return buildBean;
    }
}
