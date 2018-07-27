package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.MeasureBean;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class MeasureCalcBuilder extends CalcBuilder {
    public MeasureCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        MeasureBean bean = (MeasureBean)getBuildBean();
        return new MeasureCalc(bean.getPrevMeasure(), bean.getCurrentMeasure(), bean.getRate(), bean.isPaid(), bean.getType());
    }
}
