package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class CalcReadingConverter implements
        IConverter<ServiceCalc,IReading> {

    public IReading convert(ServiceCalc entry) {
        Collection<IMeasure> measures = CollectionUtil.create();
        for(ICalculation calc : entry.calcs()) {
            measures.addAll(new CalculationMeasuresConverter().convert(calc));
        }
        return new Reading(entry.getDate(),measures);
    }
}
