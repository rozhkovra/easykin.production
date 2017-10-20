package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.DoubleSimpleCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.OdnSimpleCalc;

public class HotWaterCalc extends DoubleSimpleCalc {
	
	public HotWaterCalc(double hotPrevMesure2, double hotCurrentMesure2, double hotPrevMesure, double hotCurrentMesure,
			Money rate, boolean isPaid) {
		super(hotPrevMesure2,hotCurrentMesure2,hotPrevMesure, hotCurrentMesure, rate, isPaid);
	}

	public CalculationType getType() {
		return CalculationType.HOTWATER;
	}
}