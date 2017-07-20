package ru.rrozhkov.easykin.data.impl.stat;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Arrays;

public class StaticAutoServiceDataProvider extends CollectionDataProvider<IService>{
	
	public StaticAutoServiceDataProvider(){
        super(CollectionUtil.copy(Arrays.asList(
            	ServiceFactory.createRepairService("Замена свечей", MoneyFactory.create(0.0), DateUtil.parse("04.01.2017")
						, Arrays.asList(ServiceFactory.createDetail("Свечи NGK 16мм", MoneyFactory.create(580.0), DateUtil.parse("04.01.2017"))
									, ServiceFactory.createDetail("Свечной ключ на 16мм", MoneyFactory.create(190.0), DateUtil.parse("03.01.2017"))))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(1000.0), DateUtil.parse("12.01.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(500.0), DateUtil.parse("24.01.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(300.0), DateUtil.parse("28.01.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(1000.0), DateUtil.parse("05.02.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(1000.0), DateUtil.parse("14.02.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(300.0), DateUtil.parse("07.03.2017"))
						, ServiceFactory.createService("Заправка", MoneyFactory.create(300.0), DateUtil.parse("18.03.2017"))
				)));
	}
}