package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.model.service.calc2.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.CalcBuilderFactory;
import ru.rrozhkov.easykin.service.calc2.impl.factory.AbstractService2Factory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 12/11/2017.
 */
public class Calc2Factory {
    private static final CalcBuilderFactory calcBuilderBeanFactory = new CalcBuilderFactory();
    public static class Holder {
        public static final Calc2Factory INSTANCE = new Calc2Factory();
    }

    public static Calc2Factory instance(){
        return Holder.INSTANCE;
    }

    private Calc2Factory() {
    }

    public ICalculation createWaterCalc(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        return getCalculation(WaterCalc2.class, calcBuilderBeanFactory.water(oldReading, newReading, rates));
    }

    public ICalculation createRateCalc(CalculationType type, IReading newReading, Collection<IRate> rates) {
        return getCalculation(RateCalc.class, calcBuilderBeanFactory.rate(newReading, rates, type));
    }

    public ICalculation createMeasureCalc(CalculationType type, IReading oldReading, IReading newReading,
                                           Collection<IRate> rates) {
        return getCalculation(MeasureCalc.class, calcBuilderBeanFactory.measure(oldReading, newReading, rates, type));
    }

    private ICalculation getCalculation(Class clazz, ICalcBean bean) {
        return AbstractService2Factory.instance(clazz).buildCalculation(bean);
    }


    public ICalculation createEmptyServiceCalc(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        Date lastDayOfMonth = DateUtil.lastDayOfMonth(DateUtil.today());
        return CalcFactory.createServiceCalc(lastDayOfMonth,
                Arrays.asList(
                        createWaterCalc(oldReading, newReading, rates)
                        , createMeasureCalc(CalculationType.HOTWATER, oldReading, newReading, rates)
                        , createMeasureCalc(CalculationType.ELECTRICITY, oldReading, newReading, rates)
                        , createRateCalc(CalculationType.GAZ, newReading, rates)
                        , createRateCalc(CalculationType.HEATING,newReading, rates)
                        , createRateCalc(CalculationType.REPAIR, newReading, rates)
                        , createRateCalc(CalculationType.ANTENNA, newReading, rates)
                        , createRateCalc(CalculationType.INTERCOM, newReading, rates)
                        , createRateCalc(CalculationType.HOUSE, newReading, rates)
                        , createRateCalc(CalculationType.GARBAGE, newReading, rates)
                )
        );
    }
}
