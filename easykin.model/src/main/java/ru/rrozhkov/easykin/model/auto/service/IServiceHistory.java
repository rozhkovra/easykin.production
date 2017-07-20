package ru.rrozhkov.easykin.model.auto.service;

import ru.rrozhkov.easykin.model.auto.ICar;

import java.util.Collection;

public interface IServiceHistory {
	ICar getCar();
	Collection<IService> getServices();
}