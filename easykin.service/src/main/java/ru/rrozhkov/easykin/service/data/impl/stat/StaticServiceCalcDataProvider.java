package ru.rrozhkov.easykin.service.data.impl.stat;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.CalcFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Arrays;
import java.util.Collection;

public class StaticServiceCalcDataProvider extends CollectionDataProvider<ServiceCalc> {

	private static Collection<ServiceCalc> serviceCalcs = Arrays.asList(
				(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.12.2016"),
						Arrays.asList(
//  		  				createWaterCalc(487, 495, 379, 386, new Money(14.14), new Money(17.25), new Money(12.20))
								CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(1.22), true)
								, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(941.19), true)
//    						, createHotWaterCalc(379, 386, new Money(78.95), new Money(15.12))
								, CalcFactory.createElectricityCalc(15332, 15429, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
								, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
								, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), true)
								, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), true)
								, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), true)
								, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), true)
								, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1116.75), true)
						)
				)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.01.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(373.22), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(941.19), true)
							, CalcFactory.createElectricityCalc(15429, 15539, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1477.12), true)
					)
			)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("28.02.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(251.34), true)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(1008.42), true)
							, CalcFactory.createElectricityCalc(15539, 15632, MoneyFactory.create(3.56), MoneyFactory.create(0.0), true)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), true)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1477.12), true)
					)
			)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.03.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(1075.65), true)
							, CalcFactory.createElectricityCalc(15632, 15721, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), true)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), true)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), false)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1444.68), true)
					)
			)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.04.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(941.19), false)
							, CalcFactory.createElectricityCalc(15721, 15804, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), false)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), false)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1477.12), false)
					)
			)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("31.05.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createElectricityCalc(15804, 15897, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), false)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), false)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1477.12), false)
					)
			)
				,(ServiceCalc) CalcFactory.createServiceCalc(DateUtil.parse("30.06.2017"),
					Arrays.asList(
							CalcFactory.createDefaultCalc(CalculationType.WATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOTWATER, MoneyFactory.create(0.00), false)
							, CalcFactory.createElectricityCalc(15897, 15897, MoneyFactory.create(3.56), MoneyFactory.create(0.0), false)
							, CalcFactory.createGazCalc(0.0, 0.0, MoneyFactory.create(80.06), false)
							, CalcFactory.createDefaultCalc(CalculationType.HEATING, MoneyFactory.create(1520.62), false)
							, CalcFactory.createDefaultCalc(CalculationType.REPAIR, MoneyFactory.create(341.03), false)
							, CalcFactory.createDefaultCalc(CalculationType.ANTENNA, MoneyFactory.create(72.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.INTERCOM, MoneyFactory.create(30.00), false)
							, CalcFactory.createDefaultCalc(CalculationType.HOUSE, MoneyFactory.create(1477.12), false)
					)
			)
				);
	public StaticServiceCalcDataProvider() {
		super(CollectionUtil.copy(serviceCalcs));
	}
}