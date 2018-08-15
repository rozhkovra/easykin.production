package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.service.calc2.impl.filter.MeasureFilterFactory;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/25/2017.
 */
public class ReadingMeasureAdapter {
    private static final MeasureFilterFactory measureFilterFactory = MeasureFilterFactory.instance();

    protected Collection<IMeasure> measures;

    public static ReadingMeasureAdapter create(IReading reading) {
        return new ReadingMeasureAdapter(reading);
    }

    private ReadingMeasureAdapter(IReading reading) {
        this.measures = CollectionUtil.copy(reading.getMeasures());
    }

    public Collection<IMeasure> getMeasuresByType(MeasureType... types) {
        return FilterUtil.filter(measures, measureFilterFactory.typeFilter(types));
    }
}
