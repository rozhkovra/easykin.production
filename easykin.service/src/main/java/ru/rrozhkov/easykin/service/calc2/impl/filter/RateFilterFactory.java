package ru.rrozhkov.easykin.service.calc2.impl.filter;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.model.service.calc2.RateType;

/**
 * Created by rrozhkov on 14.08.2018.
 */
public class RateFilterFactory {
    public static class Holder {
        public static final RateFilterFactory INSTANCE = new RateFilterFactory();
    }

    public static RateFilterFactory instance(){
        return Holder.INSTANCE;
    }

    private RateFilterFactory() {
    }

    public IFilter typeFilter(RateType type){return new RateTypeFilter(type);}
}
