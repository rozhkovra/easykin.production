package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class DefaultCalcBuilder implements ICalcBuilder {
    private CalculationType type;
    private Money price;
    private boolean isPaid;

    public DefaultCalcBuilder() {
    }

    public void init(CalculationType type, Money price, boolean isPaid) {
        this.type = type;
        this.price = price;
        this.isPaid = isPaid;
    }

    public ICalculation build() {
        return new Calculation(-1, -1, type,  isPaid, price);
    }
}
