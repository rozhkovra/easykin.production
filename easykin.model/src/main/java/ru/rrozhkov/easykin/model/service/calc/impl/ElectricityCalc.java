package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;

public class ElectricityCalc extends MeasureCalc {
	public ElectricityCalc(int prevMesure, int currentMesure, Money rate, boolean isPaid) {
		super(CollectionUtil.create(prevMesure), CollectionUtil.create(currentMesure), rate, isPaid, CalculationType.ELECTRICITY);
	}
}