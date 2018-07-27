package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.ServiceBean;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class ServiceCalcBuilder extends CalcBuilder {
    public ServiceCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        ServiceBean bean = ((ServiceBean)getBuildBean());
        return new ServiceCalc(bean.getDate(), bean.getBeans());
    }
}
