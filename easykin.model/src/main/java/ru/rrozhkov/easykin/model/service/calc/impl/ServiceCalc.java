package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import java.util.Collection;
import java.util.Date;

public class ServiceCalc extends Calculation {
	private static final int VERSION = 1;
	private Date date;
	private String name;
	private Collection<ICalculation> beans;

	public ServiceCalc(String name, Collection<ICalculation> beans) {
		super(-1, -1, CalculationType.ALL, false, Money.valueOf(0), VERSION);
		this.name = name;
		this.beans = beans;
		this.date = DateUtil.today();
	}

	public ServiceCalc(Date date, Collection<ICalculation> beans) {
		super(-1, -1, CalculationType.ALL, false, Money.valueOf(0), VERSION);
		this.name = DateUtil.formatService(date);
		this.beans = beans;
		this.date = date;
	}

	public Collection<ICalculation> calcs() {
		return beans;
	}
	
	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public boolean isPaid() {
		boolean isPaid = true;
		for(ICalculation calc : beans){
			if(!calc.isPaid())
				isPaid = false;
		}
		return isPaid;
	}	
}