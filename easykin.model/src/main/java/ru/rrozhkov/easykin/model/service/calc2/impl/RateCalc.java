package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class RateCalc extends DefaultCalc {
    public RateCalc(CalculationType type, Money sum, boolean isPaid) {
        super(type, sum, isPaid);
    }
}
