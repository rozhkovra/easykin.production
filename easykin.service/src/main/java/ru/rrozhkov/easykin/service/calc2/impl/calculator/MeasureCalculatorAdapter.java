package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.ServiceTypeResolver;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingRateAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.MeasureBean;
import ru.rrozhkov.easykin.service.calculator.MeasureCalculator;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureCalculatorAdapter extends ServiceCalculator {
    private static final ServiceTypeResolver typeResolver = new ServiceTypeResolver();

    public MeasureCalculatorAdapter(ICalcBean bean) {
        super(bean);
    }

    public IServiceResult calculate() {
        MeasureBean bean = (MeasureBean) getCalcBean();
        MeasureType measureType = typeResolver.measure(bean.getType());
        int curr = CalcUtil.summ(ReadingMeasureAdapter.create(bean.getNewReading()).getMeasuresByType(measureType));
        int prev = CalcUtil.summ(ReadingMeasureAdapter.create(bean.getOldReading()).getMeasuresByType(measureType));
        RateType rateType = typeResolver.rate(bean.getType());
        IRate iRate = ReadingRateAdapter.create(bean.getRates()).getRateByType(rateType);
        double rate = ((Money)iRate.getValue()).getValue();
        MeasureCalculator measureCalculator = new MeasureCalculator(curr, prev, rate);
        double dSum = (Double)measureCalculator.calculate().getResult();
        Money sum = Money.valueOf(dSum);
        return new ServiceResult(sum);
    }
}
