package ru.rrozhkov.easykin.model.auto.service;

import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Collection;
import java.util.Date;

public interface IService{
	String getName();
	Money getPrice();
	Date getDate();
	Collection<IService> services();
}