package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static ru.rrozhkov.easykin.model.service.calc.CalculationType.*;

public class CalcFactory {
	public static ICalculation createWaterCalc(int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
			, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
		return new WaterCalc(coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
				, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
	}

	public static ICalculation createWaterCalc(int id, int readingId, int coldPrevMesure, int coldCurrentMesure, int coldPrevMesure2, int coldCurrentMesure2
			, int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2, Money inRate, Money outRate, boolean isPaid) {
		return new WaterCalc(id, readingId, coldPrevMesure, coldCurrentMesure, coldPrevMesure2, coldCurrentMesure2, hotPrevMesure
				, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2,inRate, outRate, isPaid);
	}
	
	public static ICalculation createHotWaterCalc(int hotPrevMesure, int hotCurrentMesure, int hotPrevMesure2, int hotCurrentMesure2
								, Money rate, boolean isPaid) {
		return new HotWaterCalc(hotPrevMesure, hotCurrentMesure, hotPrevMesure2, hotCurrentMesure2, rate,  isPaid);
	}

	public static ICalculation createElectricityCalc(int prevMesure, int currentMesure
								, Money rate, Money odn, boolean isPaid) {
		return new ElectricityCalc(prevMesure, currentMesure, rate, odn, isPaid);
	}

	public static ICalculation createGazCalc(double gazPrevMesure, double gazCurrentMesure
								, Money gazRate, boolean isPaid) {
		return new GazCalc(gazPrevMesure, gazCurrentMesure, gazRate, isPaid);
	}

	public static ICalculation createDefaultCalc(CalculationType type, Money price, boolean isPaid) {
		return new Calculation(-1, -1, type,  isPaid, price);
	}

	public static ICalculation createServiceCalc(String name, Collection<ICalculation> beans) {
		return new ServiceCalc(name, beans);
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