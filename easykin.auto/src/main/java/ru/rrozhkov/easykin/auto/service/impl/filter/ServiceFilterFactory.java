package ru.rrozhkov.easykin.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.core.filter.IFilter;

public class ServiceFilterFactory {
	public static IFilter createDateFilter(Date start, Date end){
		return new DateFilter(start,end);
	}
	public static IFilter createNoFreeFilter(){
		return new NoFreeFilter();
	}
}