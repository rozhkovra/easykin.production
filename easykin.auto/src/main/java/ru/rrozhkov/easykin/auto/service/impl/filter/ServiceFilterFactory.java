package ru.rrozhkov.easykin.auto.service.impl.filter;

import java.util.Date;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class ServiceFilterFactory {
	public static class Holder {
		public static final ServiceFilterFactory INSTANCE = new ServiceFilterFactory();
	}

	public static ServiceFilterFactory instance(){
		return Holder.INSTANCE;
	}

	private ServiceFilterFactory() {
	}

	public static IFilter createDateFilter(Date start, Date end){
		return new DateFilter(start,end);
	}
	public static IFilter createNoFreeFilter(){
		return new IFilter<IService>() {
			public boolean filter(IService obj) {
				return !obj.getPrice().free();
			}
		};
	}
}