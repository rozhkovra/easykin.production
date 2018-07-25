package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterCalcBuilder implements ICalcBuilder {
    private int coldPrevMesure;
    private int coldCurrentMesure;
    private int coldPrevMesure2;
    private int coldCurrentMesure2;
    private int hotPrevMesure;
    private int hotCurrentMesure;
    private int hotPrevMesure2;
    private int hotCurrentMesure2;
    private Money inRate;
    private Money outRate;
    private boolean isPaid;

    public WaterCalcBuilder() {
    }

    public void init(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
        this.coldPrevMesure = coldPrevMesure;
        this.coldCurrentMesure = coldCurrentMesure;
        this.coldPrevMesure2 = coldPrevMesure2;
        this.coldCurrentMesure2 = coldCurrentMesure2;
        this.hotPrevMesure = hotPrevMesure;
        this.hotCurrentMesure = hotCurrentMesure;
        this.hotPrevMesure2 = hotPrevMesure2;
        this.hotCurrentMesure2 = hotCurrentMesure2;
        this.inRate = inRate;
        this.outRate = outRate;
        this.isPaid = isPaid;
    }

    public ICalculation build() {
        return new WaterCalc(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
                , hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
    }
}
