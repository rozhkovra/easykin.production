package ru.rrozhkov.easykin.model.auto.service.util;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;

public class RepairUtil {
	public static Money getDetailsPrice(IService service){
		Money sum = MoneyFactory.create();
		for (IService detail : service.services()) {
			sum.add(detail.getPrice());
		}
		return sum;
	}
}
