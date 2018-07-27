package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;

import java.util.Collection;

public class HotWaterCalc extends MeasureCalc {
	public HotWaterCalc(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure,
			Money rate, boolean isPaid) {
		super(prevMeasure, currentMeasure, rate, isPaid, CalculationType.HOTWATER);
	}
}