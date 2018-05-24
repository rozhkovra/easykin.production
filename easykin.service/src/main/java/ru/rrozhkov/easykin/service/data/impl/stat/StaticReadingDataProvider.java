package ru.rrozhkov.easykin.service.data.impl.stat;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Rate;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Factory;
import ru.rrozhkov.easykin.service.db.impl.calc2.RateHandler;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingBuilder;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class StaticReadingDataProvider extends CollectionDataProvider<IReading> {
    public static Collection<IRate> rates2018_1 = (Collection)Arrays.asList(
            new Rate(RateType.WATERIN, Money.valueOf(15.29),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.WATEROUT,Money.valueOf(18.66),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.HOTWATER,Money.valueOf(87.06),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.ELECTRICITY,Money.valueOf(3.68),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.GAZ,Money.valueOf(275.15),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.HEATING, Money.valueOf(1589.04),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.REPAIR, Money.valueOf(341.03),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.ANTENNA, Money.valueOf(72.00),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.INTERCOM, Money.valueOf(30.00),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018")),
            new Rate(RateType.HOUSE, Money.valueOf(1231.27),DateUtil.parse("01.01.2018"),DateUtil.parse("30.06.2018"))
    );

    protected static Collection<IRate> rates2018_2 = (Collection)Arrays.asList(
            new Rate(RateType.WATERIN, Money.valueOf(16.06),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.WATEROUT,Money.valueOf(19.59),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.HOTWATER,Money.valueOf(90.07),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.ELECTRICITY,Money.valueOf(3.86),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.GAZ,Money.valueOf(275.15),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.HEATING, Money.valueOf(1589.04),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.REPAIR, Money.valueOf(341.03),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.ANTENNA, Money.valueOf(72.00),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018")),
            new Rate(RateType.INTERCOM, Money.valueOf(30.00),DateUtil.parse("01.07.2018"),DateUtil.parse("31.12.2018"))
    );

    public StaticReadingDataProvider(Collection<IReading> collection) {
        super(CollectionUtil.<IReading>create());
    }

    public static Collection<ServiceCalc> calcs() {
        IReading prevReading = null;
        Collection<ServiceCalc> calcs = CollectionUtil.create();
        Collection<IReading> readings = ReadingBuilder.build();
        Collection<IRate> rates = rates2018_1;
        for(IReading reading : readings) {
            try {
                rates = RateHandler.selectForDate(reading.getDate());
            } catch (Exception e) {
                rates = rates2018_1;
            }
            if(prevReading!=null) {
                calcs.add(getServiceCalc(prevReading, reading, rates));
            }
            prevReading = reading;
        }
        return calcs;
    }

    public static ServiceCalc getServiceCalc(IReading oldReading, IReading newReading, Collection rates) {
        Collection<ICalculation> calculations = CollectionUtil.create();
        boolean paid = false;
        if(newReading.getDate().getTime() <= DateUtil.parse("30.04.2018").getTime()) {
            paid = true;
        }
        calculations.add(Calc2Factory.createWaterCalc(oldReading, newReading, rates, paid));
        calculations.add(Calc2Factory.createHotWaterCalc(oldReading, newReading, rates, paid));
        calculations.add(Calc2Factory.createElectricityCalc(oldReading, newReading, rates, paid));
        calculations.add(Calc2Factory.createGazCalc(rates, paid));
        calculations.add(Calc2Factory.createHeatingCalc(rates, paid));
        calculations.add(Calc2Factory.createRepairCalc(rates, paid));
        calculations.add(Calc2Factory.createAntennaCalc(rates, paid));
        calculations.add(Calc2Factory.createIntercomCalc(rates, paid));
        calculations.add(Calc2Factory.createHouseCalc(rates, paid));
        return new ServiceCalc(newReading.getDate(),calculations);
    }
}
