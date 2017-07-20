package ru.rrozhkov.easykin.model.auto.service.impl;

import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Date;

public class DetailService extends Service {
	public DetailService(String name, Money price, Date date) {
		super(name, price, date);;
	}
	@Override
	public String toString() {
		return "\n  " + getName() + ", " + getPrice()+"\n";
	}
}