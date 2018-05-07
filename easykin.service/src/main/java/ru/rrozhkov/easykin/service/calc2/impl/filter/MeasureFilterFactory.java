package ru.rrozhkov.easykin.service.calc2.impl.filter;

import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.lib.filter.IFilter;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureFilterFactory {
    public static IFilter readingFilter(int id) {return new MeasureReadingFilter(id);}
    public static IFilter typeFilter(MeasureType... types){return new MeasureTypeFilter(types);}
}
