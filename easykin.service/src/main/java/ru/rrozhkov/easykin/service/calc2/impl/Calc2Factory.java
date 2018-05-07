package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.rate.RateCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 12/11/2017.
 */
public class Calc2Factory {
    public static ICalculation createHotWaterCalc(IReading oldReading,
                                                  IReading newReading,
                                                  Collection<IRate> rates,
                                                  boolean isPaid) {
        Money hotRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = new ReadingMeasureAdapter(oldReading).getMeasuresByType(MeasureType.HOTWATER);
        Collection<IMeasure> newMeasures = new ReadingMeasureAdapter(newReading).getMeasuresByType(MeasureType.HOTWATER);
        for(IRate rate : rates) {
            if(rate.getType().isHotWater()) {
                hotRate = Money.valueOf(rate.getValue());
            }
        }
        return new HotWaterCalc(oldMeasures, newMeasures, hotRate, isPaid);

    }

    public static ICalculation createWaterCalc(IReading oldReading,
                                               IReading newReading,
                                               Collection<IRate> rates,
                                               boolean isPaid) {
        Collection<IMeasure> oldMeasures = oldReading.getMeasures();
        Collection<IMeasure> newMeasures = newReading.getMeasures();
        int coldWater1Prev = 0;
        int coldWater1Curr = 0;
        int coldWater2Prev = 0;
        int coldWater2Curr = 0;
        int hotWater1Prev = 0;
        int hotWater1Curr = 0;
        int hotWater2Prev = 0;
        int hotWater2Curr = 0;
        Money inRate = Money.valueOf(0.00);
        Money outRate = Money.valueOf(0.00);
        for(IMeasure measure : newMeasures) {
            if(measure.getType().isColdWater()) {
                int coldWater = (Integer)measure.getValue();
                if(coldWater1Curr==0) {
                    coldWater1Curr = coldWater;
                } else {
                    coldWater2Curr = coldWater;
                }
            } else if(measure.getType().isHotWater()) {
                int hotWater = (Integer)measure.getValue();
                if(hotWater1Curr==0) {
                    hotWater1Curr = hotWater;
                } else {
                    hotWater2Curr = hotWater;
                }
            }
        }
        for(IMeasure measure : oldMeasures) {
            if(measure.getType().isColdWater()) {
                int coldWater = (Integer)measure.getValue();
                if(coldWater1Prev==0) {
                    coldWater1Prev = coldWater;
                } else {
                    coldWater2Prev = coldWater;
                }
            } else if(measure.getType().isHotWater()) {
                int hotWater = (Integer)measure.getValue();
                if(hotWater1Prev==0) {
                    hotWater1Prev = hotWater;
                } else {
                    hotWater2Prev = hotWater;
                }
            }
        }
        for(IRate rate : rates) {
            if(rate.getType().isWaterIn()) {
                inRate = Money.valueOf(rate.getValue());
            } else if(rate.getType().isWaterOut()) {
                outRate = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createWaterCalc(coldWater1Prev, coldWater1Curr, coldWater2Prev, coldWater2Curr,
                hotWater1Prev, hotWater1Curr, hotWater2Prev, hotWater2Curr, inRate, outRate, isPaid);

    }

    public static ICalculation createElectricityCalc(IReading oldReading,
                                                     IReading newReading,
                                                     Collection<IRate> rates,
                                                     boolean isPaid) {
        Money electricityRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = new ReadingMeasureAdapter(oldReading).getMeasuresByType(MeasureType.ELECTRICITY);
        Collection<IMeasure> newMeasures = new ReadingMeasureAdapter(newReading).getMeasuresByType(MeasureType.ELECTRICITY);

        for(IRate rate : rates) {
            if(rate.getType().isElectricity()) {
                electricityRate = Money.valueOf(rate.getValue());
            }
        }
        return new ElectricityCalc(oldMeasures, newMeasures, electricityRate, isPaid);
    }

    public static ICalculation createAntennaCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isAntenna()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.ANTENNA, money, isPaid);
    }

    public static ICalculation createIntercomCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isIntercom()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.INTERCOM, money, isPaid);
    }

    public static ICalculation createHeatingCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isHeating()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.HEATING, money, isPaid);
    }

    public static ICalculation createRepairCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isRepair()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.REPAIR, money, isPaid);
    }

    public static ICalculation createGazCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isGaz()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.GAZ, money, isPaid);
    }

    public static ICalculation createHouseCalc(Collection<IRate> rates, boolean isPaid) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isHouse()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return new RateCalc(CalculationType.HOUSE, money, isPaid);
    }

    public static ICalculation createEmptyServiceCalc(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        Date lastDayOfMonth = DateUtil.lastDayOfMonth(DateUtil.today());
        return CalcFactory.createServiceCalc(lastDayOfMonth,
                Arrays.asList(
                        createWaterCalc(oldReading,newReading,rates,false)
                        , createHotWaterCalc(oldReading, newReading, rates, false)
                        , createElectricityCalc(oldReading, newReading, rates, false)
                        , createGazCalc(rates, false)
                        , createHeatingCalc(rates, false)
                        , createRepairCalc(rates, false)
                        , createAntennaCalc(rates, false)
                        , createIntercomCalc(rates, false)
                        , createHouseCalc(rates, false)
                )
        );
    }
}
