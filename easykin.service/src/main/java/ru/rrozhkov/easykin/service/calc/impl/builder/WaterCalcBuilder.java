package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.WaterCalc;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.WaterBean;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterCalcBuilder implements ICalcBuilder {
    ICalcBuildBean buildBean;

    public WaterCalcBuilder(ICalcBuildBean buildBean) {
        this.buildBean = buildBean;
    }

    public ICalculation build() {
        return new WaterCalc(((WaterBean)buildBean).getColdPrevMesure(),
                ((WaterBean)buildBean).getColdCurrentMesure(),
                ((WaterBean)buildBean).getColdPrevMesure2(),
                ((WaterBean)buildBean).getColdCurrentMesure2(),
                ((WaterBean)buildBean).getHotPrevMesure(),
                ((WaterBean)buildBean).getHotCurrentMesure(),
                ((WaterBean)buildBean).getHotPrevMesure2(),
                ((WaterBean)buildBean).getHotCurrentMesure2(),
                ((WaterBean)buildBean).getInRate(),
                ((WaterBean)buildBean).getOutRate(),
                ((WaterBean)buildBean).isPaid());
    }
}
