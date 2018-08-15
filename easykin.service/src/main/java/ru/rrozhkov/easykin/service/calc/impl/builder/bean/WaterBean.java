package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class WaterBean implements ICalcBean {
    private int coldPrevMeasure;
    private int coldCurrentMeasure;
    private int coldPrevMeasure2;
    private int coldCurrentMeasure2;
    private int hotPrevMeasure;
    private int hotCurrentMeasure;
    private int hotPrevMeasure2;
    private int hotCurrentMeasure2;
    private Money inRate;
    private Money outRate;
    private boolean isPaid;

    public WaterBean(int coldPrevMeasure, int coldCurrentMeasure, int coldPrevMeasure2, int coldCurrentMeasure2, int hotPrevMeasure, int hotCurrentMeasure, int hotPrevMeasure2, int hotCurrentMeasure2, Money inRate, Money outRate, boolean isPaid) {
        this.coldPrevMeasure = coldPrevMeasure;
        this.coldCurrentMeasure = coldCurrentMeasure;
        this.coldPrevMeasure2 = coldPrevMeasure2;
        this.coldCurrentMeasure2 = coldCurrentMeasure2;
        this.hotPrevMeasure = hotPrevMeasure;
        this.hotCurrentMeasure = hotCurrentMeasure;
        this.hotPrevMeasure2 = hotPrevMeasure2;
        this.hotCurrentMeasure2 = hotCurrentMeasure2;
        this.inRate = inRate;
        this.outRate = outRate;
        this.isPaid = isPaid;
    }

    public int getColdPrevMeasure() {
        return coldPrevMeasure;
    }

    public int getColdCurrentMeasure() {
        return coldCurrentMeasure;
    }

    public int getColdPrevMeasure2() {
        return coldPrevMeasure2;
    }

    public int getColdCurrentMeasure2() {
        return coldCurrentMeasure2;
    }

    public int getHotPrevMeasure() {
        return hotPrevMeasure;
    }

    public int getHotCurrentMeasure() {
        return hotCurrentMeasure;
    }

    public int getHotPrevMeasure2() {
        return hotPrevMeasure2;
    }

    public int getHotCurrentMeasure2() {
        return hotCurrentMeasure2;
    }

    public Money getInRate() {
        return inRate;
    }

    public Money getOutRate() {
        return outRate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public CalculationType getType() {
        return CalculationType.WATER;
    }
}
