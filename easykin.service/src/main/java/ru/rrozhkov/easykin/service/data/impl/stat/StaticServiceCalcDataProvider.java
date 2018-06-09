package ru.rrozhkov.easykin.service.data.impl.stat;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;

public class StaticServiceCalcDataProvider extends CollectionDataProvider<ServiceCalc> {
	private static Collection<ServiceCalc> serviceCalcs = Arrays.asList(
			(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.12.2017"),
					Arrays.asList(
							CalcFactory.createWaterCalc(41, 45, 14, 15, 33, 37, 26, 27, Money.valueOf(15.29),Money.valueOf(18.56),true)
							, CalcFactory.createHotWaterCalc(33, 37, 26, 27, Money.valueOf(90.07), true)
							, CalcFactory.createElectricityCalc(16380, 16465, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createDefaultCalc(CalculationType.GAZ, Money.valueOf(275.17), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1288.79), true)
					)
			),
			(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.11.2017"),
					Arrays.asList(
							CalcFactory.createWaterCalc(36, 41, 14, 14, 29, 33, 24, 26, Money.valueOf(15.29),Money.valueOf(18.56),true)
							, CalcFactory.createHotWaterCalc(29, 33, 24, 26, Money.valueOf(90.07), true)
							, CalcFactory.createElectricityCalc(16291, 16380, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createDefaultCalc(CalculationType.GAZ, Money.valueOf(275.17), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1230.25), true)
					)
			),
			(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.10.2017"),
					Arrays.asList(
							CalcFactory.createWaterCalc(32, 36, 13, 14, 25, 29, 23, 24, Money.valueOf(15.29),Money.valueOf(18.56),true)
							, CalcFactory.createHotWaterCalc(25, 29, 23, 24, Money.valueOf(90.07), true)
							, CalcFactory.createElectricityCalc(16213, 16291, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createDefaultCalc(CalculationType.GAZ, Money.valueOf(275.17),true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1216.51), true)
					)
			),
			(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.09.2017"),
					Arrays.asList(
							CalcFactory.createWaterCalc(27, 32, 12, 13, 21, 25, 21, 23, Money.valueOf(15.29), Money.valueOf(18.56), true)
							, CalcFactory.createHotWaterCalc(21, 25, 21, 23, Money.valueOf(90.07), true)
							, CalcFactory.createElectricityCalc(16130, 16213, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1220.07), true)
					)
			)
			,			(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.08.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(297.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(450.35), true)
							, CalcFactory.createElectricityCalc(16066, 16130, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1208.87), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.07.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(259.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(270.21), true)
							, CalcFactory.createElectricityCalc(15978, 16066, Money.valueOf(3.68), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1589.04), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1228.22), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.06.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(284.13), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(430.95), true)
							, CalcFactory.createElectricityCalc(15897, 15978, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1218.54), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.05.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(231.37), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(172.38), true)
							, CalcFactory.createElectricityCalc(15804, 15897, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1063.69), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.04.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(490.78), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(407.68), true)
							, CalcFactory.createElectricityCalc(15721, 15804, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1243.48), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.03.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(490.78), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(1075.65), true)
							, CalcFactory.createElectricityCalc(15632, 15721, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1444.68), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("28.02.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(251.34), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(1008.42), true)
							, CalcFactory.createElectricityCalc(15539, 15632, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1477.12), true)
					)
			)
			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.01.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(373.22), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(941.19), true)
							, CalcFactory.createElectricityCalc(15429, 15539, Money.valueOf(3.56), Money.valueOf(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1477.12), true)
					)
			)
 			,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.12.2016"),
						Arrays.asList(
//  		  				createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
								CalcFactory.createDefaultCalc(CalculationType.WATER, Money.valueOf(1.22), true)
								, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, Money.valueOf(941.19), true)
//    						, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
								, CalcFactory.createElectricityCalc(15332, 15429, Money.valueOf(3.56), Money.valueOf(0.0), true)
								, CalcFactory.createGazCalc(0.0, 0.0, Money.valueOf(80.06), true)
								, CalcFactory.createDefaultCalc(CalculationType.HEATING, Money.valueOf(1520.62), true)
								, CalcFactory.createDefaultCalc(CalculationType.REPAIR, Money.valueOf(341.03), true)
								, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, Money.valueOf(72.00), true)
								, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, Money.valueOf(30.00), true)
								, CalcFactory.createDefaultCalc(CalculationType.HOUSE, Money.valueOf(1116.75), true)
						)
				)
				);
	public StaticServiceCalcDataProvider() {
		super(CollectionUtil.copy(serviceCalcs));
	}
}