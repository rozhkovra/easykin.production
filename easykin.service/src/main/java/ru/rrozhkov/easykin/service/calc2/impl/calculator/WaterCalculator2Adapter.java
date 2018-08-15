package ru.rrozhkov.easykin.service.calc2.impl.calculator;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.ICalcBean;
import ru.rrozhkov.easykin.model.service.calc.IServiceResult;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceResult;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingRateAdapter;
import ru.rrozhkov.easykin.service.calc2.impl.builder.bean.WaterBean;
import ru.rrozhkov.easykin.service.calculator.WaterCalculator;

/**
 * Created by rrozhkov on 22.07.2018.
 */
public class WaterCalculator2Adapter extends MeasureCalculatorAdapter {

    public WaterCalculator2Adapter(ICalcBean bean) {
        super(bean);
    }

    @Override
    public IServiceResult calculate() {
        WaterBean bean = (WaterBean) getCalcBean();
        IRate iRateIn = ReadingRateAdapter.create(bean.getRates()).getRateByType(RateType.WATERIN);
        double rateIn = ((Money)iRateIn.getValue()).getValue();
        IRate iRateOur = ReadingRateAdapter.create(bean.getRates()).getRateByType(RateType.WATEROUT);
        double rateOut = ((Money)iRateOur.getValue()).getValue();
        int currCold = CalcUtil.summ(bean.getNewReading().getMeasures(), MeasureType.COLDWATER);
        int prevCold = CalcUtil.summ(bean.getOldReading().getMeasures(), MeasureType.COLDWATER);
        int currHot = CalcUtil.summ(bean.getNewReading().getMeasures(), MeasureType.HOTWATER);
        int prevHot = CalcUtil.summ(bean.getOldReading().getMeasures(), MeasureType.HOTWATER);
        WaterCalculator waterCalculator = new WaterCalculator(rateIn, rateOut, currCold, prevCold, currHot, prevHot);
        double result = (Double)waterCalculator.calculate().getResult();
        Money sum = Money.valueOf(result);
        return new ServiceResult(sum);
    }
}
