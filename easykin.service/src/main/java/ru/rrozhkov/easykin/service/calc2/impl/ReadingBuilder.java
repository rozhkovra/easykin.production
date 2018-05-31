package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.db.impl.calc2.MeasureHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.ReadingHandler;
import ru.rrozhkov.easykin.service.calc2.impl.filter.MeasureFilterFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReadingBuilder {
	public IReading build(int id, Date date){
		IReading reading = null;
		try {
			Collection<IMeasure> measures = MeasureHandler.selectForReading(id);
			reading = ServiceFactory.createReading(id, date, measures);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reading;
	}

	public IReading buildNew(){
		IReading oldReading = last();
		IReading newReading = null;
		try {
			newReading = ((Reading)oldReading).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return newReading;
	}

	public IReading last(){
		List<IReading> readings = (List) build();
		return readings.get(readings.size()-1);
	}

	public Collection<IReading> build(){
		try {
			Collection<IReading> readings = ReadingHandler.select();
			Collection<IMeasure> measures = MeasureHandler.select();
			for(IReading reading : readings){
				reading.getMeasures().clear();
				reading.getMeasures().addAll(FilterUtil.filter(measures, MeasureFilterFactory.readingFilter(reading.getId())));
			}
			return readings;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CollectionUtil.create();
	}
}
