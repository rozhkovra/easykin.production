package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.DefaultCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.MeasureCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.ServiceCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.WaterCalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

@Deprecated
public class CalcFactory {
	public static ICalculation createWaterCalc(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
			, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.instance(WaterCalc.class).getCalcBuilder();
		((WaterCalcBuilder)builder).init(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
				, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
		return builder.build();
	}

	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2
								, Money rate, boolean isPaid) {
		return createMeasureCalc(CollectionUtil.create(hotPrevMesure, hotPrevMesure2),
				CollectionUtil.create(hotCurrentMesure, hotCurrentMesure2), rate, isPaid, CalculationType.HOTWATER);
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure, Money rate, boolean isPaid) {
		return createMeasureCalc(CollectionUtil.create(prevMesure), CollectionUtil.create(currentMesure),
				rate, isPaid, CalculationType.ELECTRICITY);
	}

	public static ICalculation createGazCalc(double prevMeasure, double currentMeasure, Money rate, boolean isPaid) {
		return createMeasureCalc(CollectionUtil.create((int) prevMeasure), CollectionUtil.create((int) currentMeasure),
				rate, isPaid, CalculationType.GAZ);
	}

	private static ICalculation createMeasureCalc(Collection<Integer> prevMesure, Collection<Integer> currentMesure
			, Money rate, boolean isPaid, CalculationType type) {
		ICalcBuilder builder = AbstractServiceFactory.instance(MeasureCalc.class).getCalcBuilder();
		((MeasureCalcBuilder)builder).init(prevMesure, currentMesure, rate, isPaid, type);
		return builder.build();
	}

	public static ICalculation createDefaultCalc(CalculationType type, Money price, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.defaultInstance().getCalcBuilder();
		((DefaultCalcBuilder)builder).init(type, price, isPaid);
		return builder.build();
	}

	public static ICalculation createServiceCalc(Date date, Collection<ICalculation> beans) {
		ICalcBuilder builder = AbstractServiceFactory.instance(ServiceCalc.class).getCalcBuilder();
		((ServiceCalcBuilder)builder).init(date, beans);
		return builder.build();
	}

	public static ICalculation createEmptyServiceCalc() {
		return createServiceCalc(DateUtil.lastDayOfMonth(DateUtil.today()),
				Arrays.asList(
						createWaterCalc(0,0,0,0,0,0,0,0,Money.valueOf(0.00),Money.valueOf(0.00),false)
						, createHotWaterCalc(0,0,0,0,Money.valueOf(0.00),false)
						, createElectricityCalc(0, 0, Money.valueOf(3.56), false)
						, createGazCalc(0.0, 0.0, Money.valueOf(80.06), false)
						, createDefaultCalc(CalculationType.HEATING, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.REPAIR, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(0.00), false)
						, createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(40.00), false)
						, createDefaultCalc(CalculationType.HOUSE, Money.valueOf(0.00), false)
				)
		);
	}
}