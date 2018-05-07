package ru.rrozhkov.easykin.service.calc2.impl;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.service.calc2.impl.filter.MeasureFilterFactory;
import ru.rrozhkov.easykin.service.calc2.impl.filter.MeasureTypeFilter;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/25/2017.
 */
public class ReadingMeasureAdapter {
    protected Collection<IMeasure> measures;
    protected double coldMeasure;
    protected double coldMeasure2;
    protected double hotMeasure;
    protected double hotMeasure2;
    protected int electricityMeasure;

    public ReadingMeasureAdapter(IReading reading) {
        this.measures = CollectionUtil.copy(reading.getMeasures());
        this.coldMeasure = 0.0;
        this.coldMeasure2 = 0.0;
        this.hotMeasure = 0.0;
        this.hotMeasure2 = 0.0;
        this.electricityMeasure = 0;
    }

    public double getColdMeasure() {
        for(IMeasure measure : measures) {
            if(measure.getType().isColdWater()) {
                measures.remove(measure);
                coldMeasure = (Double)measure.getValue();
                break;
            }
        }
        return coldMeasure;
    }
    public double getColdMeasure2() {
        for(IMeasure measure : measures) {
            if(measure.getType().isColdWater()) {
                measures.remove(measure);
                coldMeasure2 = (Double)measure.getValue();
                break;
            }
        }
        return coldMeasure2;

    }
    public double getHotMeasure() {
        for(IMeasure measure : measures) {
            if(measure.getType().isHotWater()) {
                measures.remove(measure);
                hotMeasure = (Double)measure.getValue();
                break;
            }
        }
        return hotMeasure;
    }
    public double getHotMeasure2() {
        for(IMeasure measure : measures) {
            if(measure.getType().isHotWater()) {
                measures.remove(measure);
                hotMeasure2 = (Double)measure.getValue();
                break;
            }
        }
        return hotMeasure2;
    }
    public int getElectricityMeasure(){
        for(IMeasure measure : measures) {
            if(measure.getType().isElectricity()) {
                measures.remove(measure);
                double value = Double.valueOf(measure.getValue().toString());
                electricityMeasure = (int)value;
                break;
            }
        }
        return electricityMeasure;
    }

    public Collection<IMeasure> getMeasuresByType(MeasureType... types) {
        return FilterUtil.filter(measures, MeasureFilterFactory.typeFilter(types));
    }
}
