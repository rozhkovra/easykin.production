package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class GazCalcBuilder implements ICalcBuilder {
    private double gazPrevMesure;
    private double gazCurrentMesure;
    private Money gazRate;
    private boolean isPaid;

    public GazCalcBuilder() {
    }

    public void init(double gazPrevMesure, double gazCurrentMesure, Money gazRate, boolean isPaid) {
        this.gazPrevMesure = gazPrevMesure;
        this.gazCurrentMesure = gazCurrentMesure;
        this.gazRate = gazRate;
        this.isPaid = isPaid;
    }

    public ICalculation build() {
        return new GazCalc(gazPrevMesure, gazCurrentMesure, gazRate, isPaid);
    }
}
