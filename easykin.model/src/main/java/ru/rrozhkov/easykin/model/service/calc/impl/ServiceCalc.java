package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.lib.util.DateUtil;


import java.util.Collection;
import java.util.Date;

public class ServiceCalc extends Calculation {
	private Date date;
	private String name;
	private Collection<ICalculation> beans;

	public ServiceCalc(String name, Collection<ICalculation> beans) {
		super(false);
		this.name = name;
		this.beans = beans;
		this.date = new Date();
	}

	public ServiceCalc(Date date, Collection<ICalculation> beans) {
		super(false);
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
	
	public CalculationType getType() {
		return CalculationType.ALL;
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