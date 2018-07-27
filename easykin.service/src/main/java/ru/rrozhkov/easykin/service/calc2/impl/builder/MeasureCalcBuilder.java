package ru.rrozhkov.easykin.service.calc2.impl.builder;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.ServiceTypeResolver;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.CalcBuilder;
import ru.rrozhkov.easykin.service.ICalcBuildBean;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.MeasureBean;

import java.util.Collection;

/**
 * Created by rrozhkov on 25.07.2018.
 */
public class MeasureCalcBuilder extends CalcBuilder {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();

    public MeasureCalcBuilder(ICalcBuildBean buildBean) {
        super(buildBean);
    }

    public ICalculation build() {
        MeasureBean bean = (MeasureBean)getBuildBean();
        Money hotRate = Money.valueOf(0.00);
        Collection<IMeasure> oldMeasures = ReadingMeasureAdapter.create(bean.getOldReading()).getMeasuresByType(typeResolver.measure(bean.getType()));
        Collection<IMeasure> newMeasures = ReadingMeasureAdapter.create(bean.getNewReading()).getMeasuresByType(typeResolver.measure(bean.getType()));
        for(IRate rate : bean.getRates()) {
            if(rate.getType().equals(typeResolver.rate(bean.getType()))) {
                hotRate = Money.valueOf(rate.getValue());
            }
        }
        boolean isPaid = false;
        int calcId = -1;
        if (bean.getNewReading().getCalcs()!=null) {
            ICalculation calc = ServiceCalcUtil.getCalcByType(bean.getNewReading().getCalcs(), bean.getType());
            isPaid = calc != null && calc.isPaid();
            calcId = calc.getId();
        }
        return new MeasureCalc(calcId, bean.getNewReading().getId(), bean.getType(), hotRate, isPaid, oldMeasures, newMeasures);
    }
}
