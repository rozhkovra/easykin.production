package ru.rrozhkov.easykin.model.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.filter.IFilter;

public class DateFilter implements IFilter<IService>{
	private Date start;
	private Date end;
	public DateFilter(Date start, Date end) {
		this.start = start;
		this.end = end;
	}
	
	public boolean filter(IService obj){
		return obj.getDate().getTime()>=start.getTime() 
				&& obj.getDate().getTime()<end.getTime();
	}
}