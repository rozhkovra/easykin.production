package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.IServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.ICalc2Bean;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class Calc2Builder implements ICalcBuilder {
    private static final PaymentFactory paymentFactory = PaymentFactory.instance();
    private ICalc2Bean buildBean;
    private IServiceCalculator calculator;

    public Calc2Builder(ICalc2Bean buildBean, IServiceCalculator calculator) {
        this.buildBean = buildBean;
        this.calculator = calculator;
    }

    public ICalc2Bean getBuildBean() {
        return buildBean;
    }

    public IServiceCalculator getCalculator() {
        return calculator;
    }

    public ICalculation build() {
        ICalc2Bean bean = getBuildBean();
        IServiceCalculator calculator = getCalculator();

        boolean isPaid = false;
        int calcId = -1;
        if (bean.getNewReading().getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(bean.getNewReading().getCalcs(), bean.getType());
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new Calculation(calcId, bean.getNewReading().getId(), bean.getType(),
                paymentFactory.createServiceCalcPayment(
                        DateUtil.formatService(bean.getNewReading().getDate()) + " " + bean.getType()
                        , calculator.calculate().getResult()
                        , bean.getNewReading().getDate(), isPaid));
    }
}
