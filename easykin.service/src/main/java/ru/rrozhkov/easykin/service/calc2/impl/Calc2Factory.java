package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.service.calc2.impl.builder.MeasureCalcBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.builder.RateCalcBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.builder.WaterCalcBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.factory.AbstractService2Factory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 12/11/2017.
 */
public class Calc2Factory {
    public static class Holder {
        public static final Calc2Factory INSTANCE = new Calc2Factory();
    }

    public static Calc2Factory instance(){
        return Holder.INSTANCE;
    }

    private Calc2Factory() {
    }

    public ICalculation createHotWaterCalc(IReading oldReading,
                                                  IReading newReading,
                                                  Collection<IRate> rates) {
        return createMeasureCalc(oldReading, newReading, rates, CalculationType.HOTWATER);
    }

    public ICalculation createWaterCalc(IReading oldReading,
                                               IReading newReading,
                                               Collection<IRate> rates) {
        ICalcBuilder builder = AbstractService2Factory.instance(WaterCalc2.class).getCalcBuilder();
        ((WaterCalcBuilder)builder).init(oldReading, newReading, rates);
        return builder.build();
    }

    public ICalculation createElectricityCalc(IReading oldReading,
                                                     IReading newReading,
                                                     Collection<IRate> rates) {
        return createMeasureCalc(oldReading, newReading, rates, CalculationType.ELECTRICITY);
    }

    public ICalculation createAntennaCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.ANTENNA);
    }

    public ICalculation createIntercomCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.INTERCOM);
    }

    public ICalculation createHeatingCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.HEATING);
    }

    public ICalculation createRepairCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.REPAIR);
    }

    public ICalculation createGazCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.GAZ);
    }

    public ICalculation createHouseCalc(IReading newReading, Collection<IRate> rates) {
        return createRateCalc(newReading, rates, CalculationType.HOUSE);
    }

    private ICalculation createRateCalc(IReading newReading, Collection<IRate> rates, CalculationType type) {
        ICalcBuilder builder = AbstractService2Factory.instance(RateCalc.class).getCalcBuilder();
        ((RateCalcBuilder)builder).init(newReading, rates, type);
        return builder.build();
    }

    private ICalculation createMeasureCalc(IReading oldReading,
                                           IReading newReading,
                                           Collection<IRate> rates, CalculationType type) {
        ICalcBuilder builder = AbstractService2Factory.instance(MeasureCalc.class).getCalcBuilder();
        ((MeasureCalcBuilder)builder).init(oldReading, newReading, rates, type);
        return builder.build();
    }


    public ICalculation createEmptyServiceCalc(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        Date lastDayOfMonth = DateUtil.lastDayOfMonth(DateUtil.today());
        return CalcFactory.createServiceCalc(lastDayOfMonth,
                Arrays.asList(
                        createWaterCalc(oldReading, newReading, rates)
                        , createHotWaterCalc(oldReading, newReading, rates)
                        , createElectricityCalc(oldReading, newReading, rates)
                        , createRateCalc(newReading, rates, CalculationType.GAZ)
                        , createRateCalc(newReading, rates, CalculationType.HEATING)
                        , createRateCalc(newReading, rates, CalculationType.REPAIR)
                        , createRateCalc(newReading, rates, CalculationType.ANTENNA)
                        , createRateCalc(newReading, rates, CalculationType.INTERCOM)
                        , createRateCalc(newReading, rates, CalculationType.HOUSE)
                )
        );
    }
}
