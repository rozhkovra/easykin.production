package ru.rrozhkov.easykin.service.calc2.impl.filter;

import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.RateType;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class RateTypeFilter implements IFilter<IRate> {
    private RateType type;
    protected RateTypeFilter(RateType type) {this.type = type;}
    public boolean filter(IRate obj) {
        return type.equals(obj.getType());
    }
}
