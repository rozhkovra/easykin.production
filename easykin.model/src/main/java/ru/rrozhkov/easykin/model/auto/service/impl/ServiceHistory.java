package ru.rrozhkov.easykin.model.auto.service.impl;

import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.IServiceHistory;

import java.util.Collection;

public class ServiceHistory implements IServiceHistory {
	private ICar car;
	private Collection<IService> services;
	
	public ServiceHistory(ICar car, Collection<IService> services) {
		this.car = car;
		this.services = services;
	}

	public ICar getCar() {
		return car;
	}

	public Collection<IService> getServices() {
		return services;
	}

	@Override
	public String toString() {
		return "\ncar=" + car + "\nservices={" + services + "}\n";
	}	
}