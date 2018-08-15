package ru.rrozhkov.easykin.service.calc.impl.builder.bean;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;

import java.util.Collection;
import java.util.Date;

/**
 * Created by rrozhkov on 27.07.2018.
 */
public class CalcBuilderFactory {
    public ICalcBean water(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
            , int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid){
        return new WaterBean(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
                , hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
    }

    public ICalcBean service(Date date, Collection<ICalculation> beans) {
        return new ServiceBean(date, beans);
    }

    public ICalcBean measure(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure, Money rate, boolean isPaid, CalculationType type) {
        return new MeasureBean(prevMeasure, currentMeasure, rate, isPaid, type);
    }

    public ICalcBean defaultBean(CalculationType type, Money price, boolean isPaid) {
        return new DefaultBean(type, price, isPaid);
    }
}
