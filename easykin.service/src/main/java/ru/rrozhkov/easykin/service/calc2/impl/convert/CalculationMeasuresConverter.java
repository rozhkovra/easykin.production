package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Measure;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.convert.IConverter;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class CalculationMeasuresConverter implements
        IConverter<ICalculation,Collection<IMeasure>> {

    public Collection<IMeasure> convert(ICalculation entry) {
        Collection<IMeasure> measures = CollectionUtil.create();
        if(entry instanceof ElectricityCalc) {
            measures.add(new Measure(null, MeasureType.ELECTRICITY,((ElectricityCalc)entry).getCurrentMeasure()));
        }else if (entry instanceof WaterCalc) {
            measures.add(new Measure(null, MeasureType.COLDWATER,((WaterCalc)entry).getColdCurrentMesure()));
            measures.add(new Measure(null, MeasureType.COLDWATER,((WaterCalc)entry).getColdCurrentMesure2()));
            measures.add(new Measure(null, MeasureType.HOTWATER,((WaterCalc)entry).getHotCurrentMesure()));
            measures.add(new Measure(null, MeasureType.HOTWATER,((WaterCalc)entry).getHotCurrentMesure2()));
        }
        return measures;
    }
}