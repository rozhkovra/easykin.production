package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class ServiceCalcBuilder implements ICalcBuilder {
    private Date date;
    private Collection<ICalculation> beans;

    public ServiceCalcBuilder() {
    }

    public void init(Date date, Collection<ICalculation> beans) {
        this.date = date;
        this.beans = beans;
    }


    public ICalculation build() {
        return new ServiceCalc(date, beans);
    }
}
