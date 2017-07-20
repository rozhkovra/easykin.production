package ru.rrozhkov.easykin.data.impl.stat;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;

import static ru.rrozhkov.easykin.model.service.calc.CalculationType.*;
import static ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory.*;

public class StaticServiceCalcDataProvider extends CollectionDataProvider<ServiceCalc> {

	private static Collection<ServiceCalc> serviceCalcs = Arrays.asList(
				(ServiceCalc)createServiceCalc(DateUtil.parse("31.12.2016"),
					Arrays.asList(
//  		  				createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
							createDefaultCalc(WATER, MoneyFactory.create(1.22), true)
							, createDefaultCalc(HOTWATER, MoneyFactory.create(941.19), true)
//    						, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
							, createElectricityCalc(15332, 15429, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
							, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
							, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), true)
							, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), true)
							, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), true)
							, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), true)
							, createDefaultCalc(HOUSE, MoneyFactory.create(1116.75), true)
							)
				)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("31.01.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(373.22), true)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(941.19), true)
								, createElectricityCalc(15429, 15539, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), true)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), true)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), true)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), true)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1477.12), true)
								)
					)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("28.02.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(251.34), true)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(1008.42), true)
								, createElectricityCalc(15539, 15632, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), true)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), true)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), false)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), false)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1477.12), true)
						)
				)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("31.03.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(0.00), false)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(1075.65), true)
								, createElectricityCalc(15632, 15721, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), true)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), false)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), false)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), false)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1444.68), true)
						)
				)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("30.04.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(0.00), false)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(941.19), false)
								, createElectricityCalc(15721, 15804, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), false)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), false)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), false)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), false)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1477.12), false)
						)
				)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("31.05.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(0.00), false)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(0.00), false)
								, createElectricityCalc(15804, 15897, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), false)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), false)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), false)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), false)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1477.12), false)
						)
				)
				,(ServiceCalc)createServiceCalc(DateUtil.parse("30.06.2017"),
						Arrays.asList(
								createDefaultCalc(WATER, MoneyFactory.create(0.00), false)
								, createDefaultCalc(HOTWATER, MoneyFactory.create(0.00), false)
								, createElectricityCalc(15897, 15897, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
								, createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
								, createDefaultCalc(HEATING, MoneyFactory.create(1520.62), false)
								, createDefaultCalc(REPAIR, MoneyFactory.create(341.03), false)
								, createDefaultCalc(ANTENNA, MoneyFactory.create(72.00), false)
								, createDefaultCalc(INTERCOM, MoneyFactory.create(30.00), false)
								, createDefaultCalc(HOUSE, MoneyFactory.create(1477.12), false)
						)
				)
				);
	public StaticServiceCalcDataProvider() {
		super(CollectionUtil.copy(serviceCalcs));
	}
}