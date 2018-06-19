package ru.rrozhkov.easykin.auto.data.impl.stat;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.data.impl.CollectionDataProvider;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Arrays;

public class StaticAutoServiceDataProvider extends CollectionDataProvider<IService>{
	private static final ServiceFactory serviceFactory = ServiceFactory.instance();
	public static class Holder {
		public static final StaticAutoServiceDataProvider INSTANCE = new StaticAutoServiceDataProvider();
	}

	public static StaticAutoServiceDataProvider instance(){
		return Holder.INSTANCE;
	}

	private StaticAutoServiceDataProvider(){
        super(CollectionUtil.copy(Arrays.asList(
				serviceFactory.createRepairService("Замена свечей", Money.valueOf(0.0), DateUtil.parse("04.01.2017")
						, Arrays.asList(serviceFactory.createDetail("Свечи NGK 16мм", Money.valueOf(580.0), DateUtil.parse("04.01.2017"))
									, serviceFactory.createDetail("Свечной ключ на 16мм", Money.valueOf(190.0), DateUtil.parse("03.01.2017"))))
						, serviceFactory.createService("Заправка", Money.valueOf(1000.0), DateUtil.parse("12.01.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(500.0), DateUtil.parse("24.01.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(300.0), DateUtil.parse("28.01.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(1000.0), DateUtil.parse("05.02.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(1000.0), DateUtil.parse("14.02.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(300.0), DateUtil.parse("07.03.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(300.0), DateUtil.parse("18.03.2017"))
						, serviceFactory.createService("Заправка", Money.valueOf(357.0), DateUtil.parse("23.08.2017"))
						, serviceFactory.createService("Штраф Превышение на 20 кмч", Money.valueOf(255.0), DateUtil.parse("24.08.2017"))
				)));
	}
}