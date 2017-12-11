package ru.rrozhkov.easykin.model.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/11/2017.
 */
public class Calc2Factory {
    public static ICalculation createServiceCalc(IReading newReading, IReading oldReading, Collection<IRate> rates) {
        Collection<ICalculation> calculations = CollectionUtil.create();
        calculations.add(Calc2Factory.createElectricityCalc(oldReading.getMeasures(), newReading.getMeasures(), rates));
        calculations.add(Calc2Factory.createWaterCalc(oldReading.getMeasures(), newReading.getMeasures(), rates));
        calculations.add(Calc2Factory.createHotWaterCalc(oldReading.getMeasures(), newReading.getMeasures(), rates));
        calculations.add(Calc2Factory.createAntennaCalc(rates));
        calculations.add(Calc2Factory.createIntercomCalc(rates));
        calculations.add(Calc2Factory.createHeatingCalc(rates));
        calculations.add(Calc2Factory.createRepairCalc(rates));
        return CalcFactory.createServiceCalc(newReading.getDate(), calculations);
    }

    public static ICalculation createHotWaterCalc(Collection<IMeasure> oldMeasures,
                                                  Collection<IMeasure> newMeasures,
                                                  Collection<IRate> rates) {
        int hotWater1Prev = 0;
        int hotWater1Curr = 0;
        int hotWater2Prev = 0;
        int hotWater2Curr = 0;
        Money hotRate = Money.ZERO;
        for(IMeasure measure : newMeasures) {
            if(measure.getType().isHotWater()) {
                int hotWater = (Integer)measure.getValue();
                if(hotWater1Curr==0) {
                    hotWater1Curr = hotWater;
                } else {
                    hotWater2Curr = hotWater;
                }
            }
        }
        for(IMeasure measure : oldMeasures) {
            if(measure.getType().isHotWater()) {
                int hotWater = (Integer)measure.getValue();
                if(hotWater1Prev==0) {
                    hotWater1Prev = hotWater;
                } else {
                    hotWater2Prev = hotWater;
                }
            }
        }
        for(IRate rate : rates) {
            if(rate.getType().isHotWater()) {
                hotRate = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createHotWaterCalc(hotWater1Prev, hotWater1Curr, hotWater2Prev, hotWater2Curr, hotRate, false);

    }

    public static ICalculation createWaterCalc(Collection<IMeasure> oldMeasures,
                                               Collection<IMeasure> newMeasures, Collection<IRate> rates) {
        int coldWater1Prev = 0;
        int coldWater1Curr = 0;
        int coldWater2Prev = 0;
        int coldWater2Curr = 0;
        int hotWater1Prev = 0;
        int hotWater1Curr = 0;
        int hotWater2Prev = 0;
        int hotWater2Curr = 0;
        Money inRate = Money.ZERO;
        Money outRate = Money.ZERO;
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
                hotWater1Prev, hotWater1Curr, hotWater2Prev, hotWater2Curr, inRate, outRate, false);

    }

    public static ICalculation createElectricityCalc(Collection<IMeasure> oldMeasures,
                                                     Collection<IMeasure> newMeasures, Collection<IRate> rates) {
        int electricityPrev = 0;
        int electricityCurr = 0;
        Money electricityRate = Money.ZERO;
        for(IMeasure measure : newMeasures) {
            if(measure.getType().isElectricity()) {
                electricityCurr = (Integer)measure.getValue();
            }
        }
        for(IMeasure measure : oldMeasures) {
            if(measure.getType().isElectricity()) {
                electricityPrev = (Integer)measure.getValue();
            }
        }
        for(IRate rate : rates) {
            if(rate.getType().isElectricity()) {
                electricityRate = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createElectricityCalc(electricityPrev, electricityCurr, electricityRate, Money.ZERO, false);
    }

    public static ICalculation createAntennaCalc(Collection<IRate> rates) {
        Money money = Money.ZERO;
        for(IRate rate : rates) {
            if(rate.getType().isAntenna()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createDefaultCalc(CalculationType.ANTENNA, money, false);
    }

    public static ICalculation createIntercomCalc(Collection<IRate> rates) {
        Money money = Money.ZERO;
        for(IRate rate : rates) {
            if(rate.getType().isIntercom()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createDefaultCalc(CalculationType.INTERCOM, money, false);
    }

    public static ICalculation createHeatingCalc(Collection<IRate> rates) {
        Money money = Money.ZERO;
        for(IRate rate : rates) {
            if(rate.getType().isHeating()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createDefaultCalc(CalculationType.HEATING, money, false);
    }

    public static ICalculation createRepairCalc(Collection<IRate> rates) {
        Money money = Money.ZERO;
        for(IRate rate : rates) {
            if(rate.getType().isRepair()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        return CalcFactory.createDefaultCalc(CalculationType.REPAIR, money, false);
    }
}
