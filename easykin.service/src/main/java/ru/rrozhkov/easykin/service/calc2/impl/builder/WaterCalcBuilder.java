package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.WaterBean;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rrozhkov on 24.07.2018.
 */
public class WaterCalcBuilder extends CalcBuilder {

    public WaterCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        WaterBean bean = (WaterBean)getBuildBean();
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(bean.getOldReading()).getMeasuresByType(MeasureType.COLDWATER);
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(bean.getNewReading()).getMeasuresByType(MeasureType.COLDWATER);
        oldMeasures.addAll(ReadingMeasureAdapter.create(bean.getOldReading()).getMeasuresByType(MeasureType.HOTWATER));
        newMeasures.addAll(ReadingMeasureAdapter.create(bean.getNewReading()).getMeasuresByType(MeasureType.HOTWATER));
        Map<RateType, Money> mapRates = CollectionUtil.map();
        for(IRate rate : bean.getRates()) {
            if(rate.getType().isWaterIn()) {
                mapRates.put(rate.getType(),Money.valueOf(rate.getValue()));
            } else if(rate.getType().isWaterOut()) {
                mapRates.put(rate.getType(),Money.valueOf(rate.getValue()));
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (bean.getNewReading().getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(bean.getNewReading().getCalcs(), CalculationType.WATER);
            isPaid = calc != null && calc.isPaid();
            calcId = calc.getId();
        }
        return new WaterCalc2(calcId, bean.getNewReading().getId(), CalculationType.WATER, mapRates, isPaid, oldMeasures, newMeasures);
    }
}
