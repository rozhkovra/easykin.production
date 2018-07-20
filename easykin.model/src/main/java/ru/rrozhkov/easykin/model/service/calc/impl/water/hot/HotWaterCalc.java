package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.DoubleSimpleCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.OdnSimpleCalc;

public class HotWaterCalc extends DoubleSimpleCalc {
	public HotWaterCalc(double hotPrevMeasure2, double hotCurrentMeasure2, double hotPrevMeasure, double hotCurrentMeasure,
			Money rate, boolean isPaid) {
		super(hotPrevMeasure2,hotCurrentMeasure2,hotPrevMeasure, hotCurrentMeasure, rate, isPaid, CalculationType.HOTWATER);
	}
}