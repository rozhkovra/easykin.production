package ru.rrozhkov.easykin.model.auto.service.impl;

import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;
import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Collection;
import java.util.Date;

public class ServiceFactory {
	public static IService createService(String name, Money money, Date date){
		return new Service(name, money, date);
	}	
	public static IService createRepairService(String name, Money money, Date date,
			Collection<IService> details){
		return new RepairService(name, money, date, details);
	}
	public static IServiceHistory createServiceHistory(ICar car, Collection<IService> services){
		return new ServiceHistory(car, services);
	}
	public static IService createDetail(String name, Money price, Date date){
		return new DetailService(name,price,date);
	}	
}