package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class DefaultBean implements ICalcBean {
    private CalculationType type;
    private Money price;
    private boolean isPaid;

    public DefaultBean(CalculationType type, Money price, boolean isPaid) {
        this.type = type;
        this.price = price;
        this.isPaid = isPaid;
    }

    public CalculationType getType() {
        return type;
    }

    public Money getPrice() {
        return price;
    }

    public boolean isPaid() {
        return isPaid;
    }
}
