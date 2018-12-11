package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.calc2.impl.filter.MeasureFilterFactory;
import ru.rrozhkov.easykin.service.db.impl.calc2.CalcHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.MeasureHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.ServiceCalc2HandlerFactory;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ReadingBuilder {
	private static final MeasureHandler measureHandler = ServiceCalc2HandlerFactory.instance().measure();
	private static final EntityHandler readingHandler = ServiceCalc2HandlerFactory.instance().reading();
	private static final ServiceFactory serviceFactory = ServiceFactory.instance();
	private static final MeasureFilterFactory measureFilterFactory = MeasureFilterFactory.instance();
	final private static CalcHandler calcHandler = ServiceCalc2HandlerFactory.instance().calc();

	public static class Holder {
		public static final ReadingBuilder INSTANCE = new ReadingBuilder();
	}

	public static ReadingBuilder instance(){
		return Holder.INSTANCE;
	}

	private ReadingBuilder() {
	}

	public IReading build(int id, Date date){
		IReading reading = null;
		try {
			Collection<IMeasure> measures = measureHandler.selectForReading(id);
			Collection<ICalculation> calcs = calcHandler.selectForReading(id);
			reading = serviceFactory.createReading(id, date, measures, calcs);
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
			Collection<IReading> readings = readingHandler.select();
			Collection<IMeasure> measures = measureHandler.select();
			Collection<ICalculation> cals = calcHandler.select();
			for(final IReading reading : readings){
				reading.getMeasures().clear();
				reading.getMeasures().addAll(FilterUtil.filter(measures, measureFilterFactory.readingFilter(reading.getId())));
				reading.getCalcs().clear();
				reading.getCalcs().addAll(FilterUtil.filter(cals, new IFilter<ICalculation>() {
					public boolean filter(ICalculation obj) {
						return obj.getReadingId()==reading.getId();
					}
				}));
			}
			return readings;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CollectionUtil.create();
	}
}
