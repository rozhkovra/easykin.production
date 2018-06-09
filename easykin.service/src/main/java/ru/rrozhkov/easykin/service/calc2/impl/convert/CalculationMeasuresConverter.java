package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Measure;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;

import java.util.Collection;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class CalculationMeasuresConverter implements
        IConverter<ICalculation,Collection<IMeasure>> {

    public Collection<IMeasure> convert(ICalculation entry) {
        Collection<IMeasure> measures = CollectionUtil.create();
        if(entry instanceof ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc) {
            measures.add(new Measure(MeasureType.ELECTRICITY,
                    ((ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc)entry).getCurrentMeasure()));
        }else if(entry instanceof ru.rrozhkov.easykin.model.service.calc2.impl.electricity.ElectricityCalc) {
            measures.addAll(((ru.rrozhkov.easykin.model.service.calc2.impl.electricity.ElectricityCalc)entry).getNewMeasures());
        }else if (entry instanceof WaterCalc) {
            measures.add(new Measure(MeasureType.COLDWATER,((WaterCalc)entry).getColdCurrentMesure()));
            measures.add(new Measure(MeasureType.COLDWATER,((WaterCalc)entry).getColdCurrentMesure2()));
            measures.add(new Measure(MeasureType.HOTWATER,((WaterCalc)entry).getHotCurrentMesure()));
            measures.add(new Measure(MeasureType.HOTWATER,((WaterCalc)entry).getHotCurrentMesure2()));
        }
        return measures;
    }
}
