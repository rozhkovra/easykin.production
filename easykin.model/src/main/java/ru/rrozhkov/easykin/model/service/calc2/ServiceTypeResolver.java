package ru.rrozhkov.easykin.model.service.calc2;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 25.07.2018.
 */
public class ServiceTypeResolver {
    private static final Map<CalculationType, RateType> rateTypeMap = new HashMap<CalculationType, RateType>() {
        {
            put(CalculationType.HEATING, RateType.HEATING);
            put(CalculationType.ANTENNA, RateType.ANTENNA);
            put(CalculationType.INTERCOM, RateType.INTERCOM);
            put(CalculationType.ELECTRICITY, RateType.ELECTRICITY);
            put(CalculationType.GAZ, RateType.GAZ);
            put(CalculationType.HOTWATER, RateType.HOTWATER);
            put(CalculationType.HOUSE, RateType.HOUSE);
            put(CalculationType.REPAIR, RateType.REPAIR);
            put(CalculationType.GARBAGE, RateType.GARBAGE);
        }
    };

    private static final Map<CalculationType, MeasureType> measureTypeMap = new HashMap<CalculationType, MeasureType>() {
        {
            put(CalculationType.ELECTRICITY, MeasureType.ELECTRICITY);
            put(CalculationType.GAZ, MeasureType.GAZ);
            put(CalculationType.HOTWATER, MeasureType.HOTWATER);
        }
    };

    public RateType rate(CalculationType type) {
        return rateTypeMap.get(type);
    }

    public MeasureType measure(CalculationType type) {
        return measureTypeMap.get(type);
    }

}
