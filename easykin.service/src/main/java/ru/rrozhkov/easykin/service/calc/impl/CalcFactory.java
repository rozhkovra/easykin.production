package ru.rrozhkov.easykin.service.calc.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.ICalcBuilder;
import ru.rrozhkov.easykin.service.calc.impl.builder.*;
import ru.rrozhkov.easykin.service.calc.impl.factory.AbstractServiceFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static ru.rrozhkov.easykin.model.service.calc.CalculationType.*;

@Deprecated
public class CalcFactory {
	public static ICalculation createWaterCalc(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
			, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.instance(CalculationType.WATER).getCalcBuilder();
		((WaterCalcBuilder)builder).init(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
				, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
		return builder.build();
	}

	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2
								, Money rate, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.instance(CalculationType.HOTWATER).getCalcBuilder();
		((HotWaterCalcBuilder)builder).init(hotPrevMesure, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2, rate, isPaid);
		return builder.build();
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure
								, Money rate, Money odn, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.instance(CalculationType.ELECTRICITY).getCalcBuilder();
		((ElectricityCalcBuilder)builder).init(prevMesure, currentMesure, rate, isPaid);
		return builder.build();
	}

	public static ICalculation createGazCalc(double gazPrevMesure, double gazCurrentMesure
								, Money gazRate, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.instance(CalculationType.GAZ).getCalcBuilder();
		((GazCalcBuilder)builder).init(gazPrevMesure, gazCurrentMesure, gazRate, isPaid);
		return builder.build();
	}

	public static ICalculation createDefaultCalc(CalculationType type, Money price, boolean isPaid) {
		ICalcBuilder builder = AbstractServiceFactory.defaultInstance().getCalcBuilder();
		((DefaultCalcBuilder)builder).init(type, price, isPaid);
		return builder.build();
	}

	public static ICalculation createServiceCalc(Date date, Collection<ICalculation> beans) {
		return new ServiceCalc(date, beans);
	}
	public static ICalculation createEmptyServiceCalc() {
		return createServiceCalc(DateUtil.lastDayOfMonth(DateUtil.today()),
				Arrays.asList(
						createWaterCalc(0,0,0,0,0,0,0,0,Money.valueOf(0.00),Money.valueOf(0.00),false)
						, createHotWaterCalc(0,0,0,0,Money.valueOf(0.00),false)
						, createElectricityCalc(0, 0, Money.valueOf(3.56), Money.valueOf(0.0), false)
						, createGazCalc(0.0, 0.0, Money.valueOf(80.06), false)
						, createDefaultCalc(HEATING, Money.valueOf(0.00), false)
						, createDefaultCalc(REPAIR, Money.valueOf(0.00), false)
						, createDefaultCalc(ANTENNA, Money.valueOf(0.00), false)
						, createDefaultCalc(INTERCOM, Money.valueOf(40.00), false)
						, createDefaultCalc(HOUSE, Money.valueOf(0.00), false)
				)
		);
	}
}