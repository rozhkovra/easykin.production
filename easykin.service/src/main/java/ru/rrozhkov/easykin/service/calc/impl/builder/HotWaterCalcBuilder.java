package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class HotWaterCalcBuilder implements ICalcBuilder {
    private int hotPrevMesure;
    private int hotCurrentMesure;
    private int hotPrevMesure2;
    private int hotCurrentMesure2;
    private Money rate;
    private boolean isPaid;

    public HotWaterCalcBuilder() {
    }

    public void init(int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money rate, boolean isPaid) {
        this.hotPrevMesure = hotPrevMesure;
        this.hotCurrentMesure = hotCurrentMesure;
        this.hotPrevMesure2 = hotPrevMesure2;
        this.hotCurrentMesure2 = hotCurrentMesure2;
        this.rate = rate;
        this.isPaid = isPaid;
    }

    public ICalculation build() {
        return new HotWaterCalc(hotPrevMesure, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2, rate,  isPaid);
    }
}
