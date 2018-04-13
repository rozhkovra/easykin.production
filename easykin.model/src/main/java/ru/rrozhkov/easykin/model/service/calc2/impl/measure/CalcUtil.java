package ru.rrozhkov.easykin.model.service.calc2.impl.measure;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;

import java.util.Collection;

/**
 * Created by rrozhkov on 4/13/2018.
 */
public class CalcUtil {
    public static int summ(Collection<IMeasure> measures) {
        int result = 0;
        for(IMeasure measure : measures) {
            if(measure.getValue() instanceof Integer) {
                result += (Integer) measure.getValue();
            } else if(measure.getValue() instanceof Double) {
                result += (Double) measure.getValue();
            }
        }
        return result;
    }
}