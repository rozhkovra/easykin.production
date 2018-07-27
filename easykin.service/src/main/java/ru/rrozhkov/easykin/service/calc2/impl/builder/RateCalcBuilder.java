package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.ServiceTypeResolver;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.RateBean;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class RateCalcBuilder extends CalcBuilder {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();

    public RateCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        RateBean bean = (RateBean)getBuildBean();
        Money money = Money.valueOf(0.00);
        for(IRate rate : bean.getRates()) {
            if(rate.getType().equals(typeResolver.rate(bean.getType()))) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (bean.getNewReading().getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(bean.getNewReading().getCalcs(), bean.getType());
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, bean.getNewReading().getId(), bean.getType(), money, isPaid);
    }
}
