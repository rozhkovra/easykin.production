package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class ServiceBean implements ICalcBean {
    private Date date;
    private Collection<ICalculation> beans;

    public ServiceBean(Date date, Collection<ICalculation> beans) {
        this.date = date;
        this.beans = beans;
    }

    public Date getDate() {
        return date;
    }

    public Collection<ICalculation> getBeans() {
        return beans;
    }

    public CalculationType getType() {
        return CalculationType.ALL;
    }

    public boolean isPaid() {
        return false;
    }
}
