package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class RateCalc extends Calculation {
    private Money ratePrice;
    public RateCalc(CalculationType type, Money ratePrice, boolean isPaid) {
        super(-1, -1, type, isPaid, ratePrice);
        this.ratePrice = ratePrice;
    }

    public RateCalc(int id, int readingId, CalculationType type, Money ratePrice, boolean isPaid) {
        super(id, readingId, type, isPaid, ratePrice);
        this.ratePrice = ratePrice;
    }

    public Money getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(Money ratePrice) {
        this.ratePrice = ratePrice;
    }
}
