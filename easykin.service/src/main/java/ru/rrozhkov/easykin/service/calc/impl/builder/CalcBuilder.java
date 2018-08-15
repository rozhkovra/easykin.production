package ru.rrozhkov.easykin.service.calc.impl.builder;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.IServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.ICalcBuilder;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class CalcBuilder implements ICalcBuilder {
    private static final PaymentFactory paymentFactory = PaymentFactory.instance();
    private ICalcBean buildBean;
    private IServiceCalculator calculator;

    public CalcBuilder(ICalcBean buildBean, IServiceCalculator calculator) {
        this.buildBean = buildBean;
        this.calculator = calculator;
    }

    public ICalcBean getBuildBean() {
        return buildBean;
    }

    public IServiceCalculator getCalculator() {
        return calculator;
    }

    public ICalculation build() {
        ICalcBean bean = getBuildBean();
        IServiceCalculator calculator = getCalculator();
        return new Calculation(-1, -1, bean.getType(),
                paymentFactory.createServiceCalcPayment(
                        DateUtil.formatService(DateUtil.today()) + " " + bean.getType()
                        , calculator.calculate().getResult()
                        , DateUtil.today(), bean.isPaid()));
    }

}
