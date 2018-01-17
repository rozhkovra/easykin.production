package ru.rrozhkov.easykin.service.impl.filter;

import ru.rrozhkov.lib.filter.IFilter;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureFilterFactory {

    public static IFilter readingFilter(int id) {
        return new MeasureReadingFilter(id);
    }
}
