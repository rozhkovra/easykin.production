package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.ServiceTypeResolver;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingRateAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.RateBean;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class RateCalculator extends ServiceCalculator {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();

    public RateCalculator(ICalcBean bean) {
        super(bean);
    }

    public IServiceResult calculate() {
        RateBean bean = (RateBean) getCalcBean();
        RateType rateType = typeResolver.rate(bean.getType());
        IRate iRate = ReadingRateAdapter.create(bean.getRates()).getRateByType(rateType);
        return new ServiceResult((Money)iRate.getValue());
    }
}
