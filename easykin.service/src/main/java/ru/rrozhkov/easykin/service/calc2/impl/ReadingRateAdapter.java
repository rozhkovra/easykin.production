package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.model.service.calc2.*;
import ru.rrozhkov.easykin.service.calc2.impl.filter.RateFilterFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 14.08.2018.
 */
public class ReadingRateAdapter {
    private static final RateFilterFactory rateFilterFactory = RateFilterFactory.instance();

    protected Collection<IRate> rates;

    public static ReadingRateAdapter create(Collection<IRate> rates) {
        return new ReadingRateAdapter(rates);
    }

    private ReadingRateAdapter(Collection<IRate> rates) {
        this.rates = rates;
    }

    public IRate getRateByType(RateType type) {
        Collection<IRate> result = FilterUtil.filter(rates, rateFilterFactory.typeFilter(type));
        return result.size() == 1 ? CollectionUtil.get(result, 0) : null;
    }
}
