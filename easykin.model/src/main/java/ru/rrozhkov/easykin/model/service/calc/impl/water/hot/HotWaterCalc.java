package ru.rrozhkov.easykin.model.service.calc.impl.water.hot;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.OdnSimpleCalc;

public class HotWaterCalc extends OdnSimpleCalc {
	
	public HotWaterCalc(double hotPrevMesure, double hotCurrentMesure,
			Money rate, Money odn, boolean isPaid) {
		super(hotPrevMesure, hotCurrentMesure, rate, odn, isPaid);
	}

	public CalculationType getType() {
		return CalculationType.HOTWATER;
	}
}