package ru.rrozhkov.easykin.service.data.impl.stat;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Rate;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Factory;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingBuilder;
import ru.rrozhkov.easykin.service.calc2.impl.service.RateService;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class StaticReadingDataProvider extends CollectionDataProvider<IReading> {
    final private static ReadingBuilder readingBuilder = ReadingBuilder.instance();
    final private static Calc2Factory calc2Factory = Calc2Factory.instance();
    final private static RateService rateService = RateService.instance();

    public static Collection<IRate> rates2018_2 = (Collection)Arrays.asList(
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

    public static class Holder {
        public static final StaticReadingDataProvider INSTANCE = new StaticReadingDataProvider();
    }

    public static StaticReadingDataProvider instance(){
        return Holder.INSTANCE;
    }

    private StaticReadingDataProvider() {
        super(CollectionUtil.<IReading>create());
    }

    public Collection<ServiceCalc> calcs() {
        Collection<ServiceCalc> calcs = CollectionUtil.create();
        Collection<IReading> readings = readingBuilder.build();
        Collection<IRate> rates;
        IReading prevReading = null;
        for(IReading reading : readings) {
            rates = rateService.rates(reading.getDate());
            if(prevReading!=null) {
                calcs.add(getServiceCalc(prevReading, reading, rates));
            }
            prevReading = reading;
        }
        return calcs;
    }

    public ServiceCalc getServiceCalc(IReading oldReading, IReading newReading, Collection rates) {
        Collection<ICalculation> calculations = CollectionUtil.create();
        calculations.add(calc2Factory.createWaterCalc(oldReading, newReading, rates));
        calculations.add(calc2Factory.createHotWaterCalc(oldReading, newReading, rates));
        calculations.add(calc2Factory.createElectricityCalc(oldReading, newReading, rates));
        calculations.add(calc2Factory.createGazCalc(newReading, rates));
        calculations.add(calc2Factory.createHeatingCalc(newReading, rates));
        calculations.add(calc2Factory.createRepairCalc(newReading, rates));
        calculations.add(calc2Factory.createAntennaCalc(newReading, rates));
        calculations.add(calc2Factory.createIntercomCalc(newReading, rates));
        calculations.add(calc2Factory.createHouseCalc(newReading, rates));
        return new ServiceCalc(newReading.getDate(),calculations);
    }
}
