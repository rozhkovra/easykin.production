package ru.rrozhkov.easykin.service.calc2.impl.filter;

import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.core.filter.IFilter;

/**
 * Created by rrozhkov on 1/17/2018.
 */
public class MeasureFilterFactory {
    public static class Holder {
        public static final MeasureFilterFactory INSTANCE = new MeasureFilterFactory();
    }

    public static MeasureFilterFactory instance(){
        return Holder.INSTANCE;
    }

    private MeasureFilterFactory() {
    }

    public IFilter readingFilter(int id) {return new MeasureReadingFilter(id);}
    public IFilter typeFilter(MeasureType... types){return new MeasureTypeFilter(types);}
}
