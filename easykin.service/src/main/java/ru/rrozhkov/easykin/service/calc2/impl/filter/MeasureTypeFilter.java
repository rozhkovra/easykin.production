package ru.rrozhkov.easykin.service.calc2.impl.filter;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.lib.filter.IFilter;

import java.util.Arrays;

/**
 * Created by rrozhkov on 12/27/2017.
 */
public class MeasureTypeFilter implements IFilter<IMeasure> {
    private MeasureType[] types;
    public MeasureTypeFilter(MeasureType... types) {this.types = types;}
    public boolean filter(IMeasure obj) {
        return Arrays.asList(types).contains(obj.getType());
    }
}
