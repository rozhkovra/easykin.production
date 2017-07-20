package ru.rrozhkov.easykin.model.auto.service.impl;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Collection;
import java.util.Date;

public class Service implements IService{
	private String name;
	private Money money;
	private Date date;
	
	public Service(String name, Money money, Date date) {
		this.name = name;
		this.money = money;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return money;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "\n " + name + ", " + money + ", " + DateUtil.format(date);
	}

	public Collection<IService> services() {
		return CollectionUtil.<IService>create();
	}	
}