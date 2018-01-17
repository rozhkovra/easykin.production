package ru.rrozhkov.easykin.service.impl.filter;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.lib.filter.IFilter;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureReadingFilter implements IFilter<IMeasure> {
    private int readingId;

    public MeasureReadingFilter(int readingId) {
        this.readingId = readingId;
    }

    public boolean filter(IMeasure obj) {
        return obj.getReadingId() == readingId;
    }
}
