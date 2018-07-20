package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.RateCalc;
import ru.rrozhkov.easykin.model.service.calc2.impl.HotWaterCalc;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;

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
        Money hotRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(oldReading).getMeasuresByType(MeasureType.HOTWATER);
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(newReading).getMeasuresByType(MeasureType.HOTWATER);
        for(IRate rate : rates) {
            if(rate.getType().isHotWater()) {
                hotRate = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.HOTWATER);
            isPaid = calc != null && calc.isPaid();
        }
        return new HotWaterCalc(-1, newReading.getId(), oldMeasures, newMeasures, hotRate, isPaid);

    }

    public ICalculation createWaterCalc(IReading oldReading,
                                               IReading newReading,
                                               Collection<IRate> rates) {
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
        boolean isPaid = false;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.WATER);
            isPaid = calc != null && calc.isPaid();
        }
        return CalcFactory.createWaterCalc(coldWater1Prev, coldWater1Curr, coldWater2Prev, coldWater2Curr,
                hotWater1Prev, hotWater1Curr, hotWater2Prev, hotWater2Curr, inRate, outRate, isPaid);

    }

    public ICalculation createElectricityCalc(IReading oldReading,
                                                     IReading newReading,
                                                     Collection<IRate> rates) {
        Money electricityRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(oldReading).getMeasuresByType(MeasureType.ELECTRICITY);
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(newReading).getMeasuresByType(MeasureType.ELECTRICITY);

        for(IRate rate : rates) {
            if(rate.getType().isElectricity()) {
                electricityRate = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.ELECTRICITY);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new ElectricityCalc(calcId, newReading.getId(), oldMeasures, newMeasures, electricityRate, isPaid);
    }

    public ICalculation createAntennaCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isAntenna()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.ANTENNA);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.ANTENNA, money, isPaid);
    }

    public ICalculation createIntercomCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isIntercom()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.INTERCOM);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.INTERCOM, money, isPaid);
    }

    public ICalculation createHeatingCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isHeating()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.HEATING);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.HEATING, money, isPaid);
    }

    public ICalculation createRepairCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isRepair()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.REPAIR);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.REPAIR, money, isPaid);
    }

    public ICalculation createGazCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isGaz()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.GAZ);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.GAZ, money, isPaid);
    }

    public ICalculation createHouseCalc(IReading newReading, Collection<IRate> rates) {
        Money money = Money.valueOf(0.00);
        for(IRate rate : rates) {
            if(rate.getType().isHouse()) {
                money = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (newReading.getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(newReading.getCalcs(), CalculationType.HOUSE);
            if (calc != null) {
                isPaid = calc.isPaid();
                calcId = calc.getId();
            }
        }
        return new RateCalc(calcId, newReading.getId(), CalculationType.HOUSE, money, isPaid);
    }

    public ICalculation createEmptyServiceCalc(IReading oldReading, IReading newReading, Collection<IRate> rates) {
        Date lastDayOfMonth = DateUtil.lastDayOfMonth(DateUtil.today());
        return CalcFactory.createServiceCalc(lastDayOfMonth,
                Arrays.asList(
                        createWaterCalc(oldReading,newReading,rates)
                        , createHotWaterCalc(oldReading, newReading, rates)
                        , createElectricityCalc(oldReading, newReading, rates)
                        , createGazCalc(newReading, rates)
                        , createHeatingCalc(newReading, rates)
                        , createRepairCalc(newReading, rates)
                        , createAntennaCalc(newReading, rates)
                        , createIntercomCalc(newReading, rates)
                        , createHouseCalc(newReading, rates)
                )
        );
    }
}
