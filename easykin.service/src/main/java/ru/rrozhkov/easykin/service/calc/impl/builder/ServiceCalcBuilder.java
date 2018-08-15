package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.IServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.ServiceBean;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class ServiceCalcBuilder extends CalcBuilder {
    public ServiceCalcBuilder(ICalcBean buildBean, IServiceCalculator calculator) {
        super(buildBean, calculator);
    }

    public ICalculation build() {
        ServiceBean bean = ((ServiceBean)getBuildBean());
        return new ServiceCalc(bean.getDate(), bean.getBeans());
    }
}
