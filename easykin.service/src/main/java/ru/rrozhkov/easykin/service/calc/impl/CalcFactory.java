package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.WaterCalc;
import ru.rrozhkov.easykin.service.calc.impl.builder.bean.CalcBuilderFactory;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Deprecated
public class CalcFactory {
	private static final CalcBuilderFactory calcBuilderBeanFactory = new CalcBuilderFactory();
	public static ICalculation createWaterCalc(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
			, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
		return AbstractServiceFactory.instance(WaterCalc.class).buildCalculation(
				calcBuilderBeanFactory.water(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
						, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2, inRate, outRate, isPaid)
		);
	}

	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2
								, Money rate, boolean isPaid) {
		return createMeasureCalc(CalculationType.HOTWATER, CollectionUtil.create(hotPrevMesure, hotPrevMesure2),
				CollectionUtil.create(hotCurrentMesure, hotCurrentMesure2), rate, isPaid);
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure, Money rate, boolean isPaid) {
		return createMeasureCalc(CalculationType.ELECTRICITY, CollectionUtil.create(prevMesure), CollectionUtil.create(currentMesure),
				rate, isPaid);
	}

	private static ICalculation createMeasureCalc(CalculationType type, Collection<Integer> prevMesure, Collection<Integer> currentMesure
			, Money rate, boolean isPaid) {
		return AbstractServiceFactory.instance(MeasureCalc.class).buildCalculation(
				calcBuilderBeanFactory.measure(prevMesure, currentMesure, rate, isPaid, type)
		);
	}

	private static ICalculation createMeasureCalc(CalculationType type, double prevMesure, double currentMesure
			, Money rate, boolean isPaid) {
		return createMeasureCalc(type, (int)prevMesure, (int)currentMesure, rate, isPaid);
	}

	private static ICalculation createMeasureCalc(CalculationType type, int prevMesure, int currentMesure
			, Money rate, boolean isPaid) {
		return createMeasureCalc(type,  CollectionUtil.create(prevMesure), CollectionUtil.create(currentMesure), rate, isPaid);
	}

	public static ICalculation createDefaultCalc(CalculationType type, Money price, boolean isPaid) {
		return AbstractServiceFactory.defaultInstance().buildCalculation(
				calcBuilderBeanFactory.defaultBean(type, price, isPaid)
		);
	}

	public static ICalculation createServiceCalc(Date date, Collection<ICalculation> beans) {
		return AbstractServiceFactory.instance(ServiceCalc.class).buildCalculation(
				calcBuilderBeanFactory.service(date, beans)
		);
	}

	public static ICalculation createEmptyServiceCalc() {
		return createServiceCalc(DateUtil.lastDayOfMonth(),
				Arrays.asList(
						createWaterCalc(0,0,0,0,0,0,0,0,Money.valueOf(0.00),Money.valueOf(0.00),false)
						, createMeasureCalc(CalculationType.HOTWATER, Arrays.asList(0, 0), Arrays.asList(0, 0), Money.valueOf(0.00), false)
						, createMeasureCalc(CalculationType.ELECTRICITY, 0, 0, Money.valueOf(3.56), false)
						, createMeasureCalc(CalculationType.GAZ, 0.0, 0.0, Money.valueOf(80.06), false)
						, createDefaultCalc(CalculationType.HEATING, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.REPAIR, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(40.00), false)
						, createDefaultCalc(CalculationType.HOUSE, Money.valueOf(0.00), false)
				)
		);
	}
}