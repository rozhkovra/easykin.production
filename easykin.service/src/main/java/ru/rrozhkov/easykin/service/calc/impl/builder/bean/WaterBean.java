package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.service.ICalcBuildBean;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class WaterBean implements ICalcBuildBean {
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

    public WaterBean(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
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

    public int getColdPrevMesure() {
        return coldPrevMesure;
    }

    public int getColdCurrentMesure() {
        return coldCurrentMesure;
    }

    public int getColdPrevMesure2() {
        return coldPrevMesure2;
    }

    public int getColdCurrentMesure2() {
        return coldCurrentMesure2;
    }

    public int getHotPrevMesure() {
        return hotPrevMesure;
    }

    public int getHotCurrentMesure() {
        return hotCurrentMesure;
    }

    public int getHotPrevMesure2() {
        return hotPrevMesure2;
    }

    public int getHotCurrentMesure2() {
        return hotCurrentMesure2;
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
}
