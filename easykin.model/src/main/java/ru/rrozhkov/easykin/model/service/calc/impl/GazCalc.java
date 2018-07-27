package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;

import java.util.Collection;

public class GazCalc extends MeasureCalc {
	public GazCalc(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure,
			Money gazRate, boolean isPaid) {
		super(prevMeasure, currentMeasure,gazRate,isPaid, CalculationType.GAZ);
	}
}