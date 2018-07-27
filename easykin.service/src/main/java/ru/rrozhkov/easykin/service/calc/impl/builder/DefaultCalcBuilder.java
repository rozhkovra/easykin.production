package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.DefaultBean;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class DefaultCalcBuilder extends CalcBuilder {
    private static final int VERSION = 1;

    public DefaultCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        DefaultBean bean = (DefaultBean)getBuildBean();
        return new Calculation(-1, -1, bean.getType(), bean.isPaid(), bean.getPrice(), VERSION);
    }
}
