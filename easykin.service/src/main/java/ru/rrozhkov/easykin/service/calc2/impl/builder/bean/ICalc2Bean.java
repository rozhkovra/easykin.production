package ru.rrozhkov.easykin.service.calc2.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc2.IReading;

/**
 * Created by rrozhkov on 15.08.2018.
 */
public interface ICalc2Bean extends ICalcBean {
    IReading getNewReading();
}
