package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc2.RateType;

import java.util.Map;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class RateCalc extends Calculation {
    private static final int VERSION = 2;
    private Money ratePrice;
    private Map<RateType, Money> rates;

    public RateCalc(CalculationType type, Money ratePrice, boolean isPaid) {
        super(-1, -1, type, isPaid, ratePrice, VERSION);
        this.ratePrice = ratePrice;
    }

    public RateCalc(int id, int readingId, CalculationType type, Money ratePrice, boolean isPaid) {
        super(id, readingId, type, isPaid, ratePrice, VERSION);
        this.ratePrice = ratePrice;
    }

    public RateCalc(int id, int readingId, CalculationType type, Map<RateType, Money> rates, boolean isPaid) {
        super(id, readingId, type, isPaid, Money.valueOf(0.0), VERSION);
        this.rates = rates;
    }

    public Money getRatePrice() {
        return ratePrice;
    }

    public void setRatePrice(Money ratePrice) {
        this.ratePrice = ratePrice;
    }

    public Map<RateType, Money> getRates() {
        return rates;
    }
}
