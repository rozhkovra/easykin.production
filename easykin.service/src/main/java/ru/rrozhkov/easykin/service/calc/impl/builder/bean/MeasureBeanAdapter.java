package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

/**
 * Created by rrozhkov on 15.08.2018.
 */
public class MeasureBeanAdapter {
    private ICalcBean calcBean;

    public MeasureBeanAdapter(ICalcBean calcBean) {
        this.calcBean = calcBean;
    }

    public int getPrevMeasure() {
        int result = 0;
        for (Integer measure : ((MeasureBean)calcBean).getPrevMeasure()) {
            result+=measure;
        }
        return result;
    }

    public int getCurrentMeasure() {
        int result = 0;
        for (Integer measure : ((MeasureBean)calcBean).getCurrentMeasure()) {
            result+=measure;
        }
        return result;
    }
}
