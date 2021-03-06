package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.service.calc2.impl.WaterCalc2;

import java.util.Collection;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ServiceConverterFactory {
    private static final ServiceFactory serviceFactory = ServiceFactory.instance();

    public static class Holder {
        public static final ServiceConverterFactory INSTANCE = new ServiceConverterFactory();
    }

    public static ServiceConverterFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceConverterFactory() {
    }

    public IEntityConverter measure(){return new MeasureConverter();}
    public IEntityConverter reading(){return new ReadingConverter();}
    public IEntityConverter rate(){return new RateConverter();}
    public IEntityConverter calc(){return new CalcConverter();}

    public IConverter calcReading() {
        return new IConverter<ServiceCalc, IReading>() {
            public IReading convert(ServiceCalc entry) {
                Collection<IMeasure> measures = CollectionUtil.create();
                for (ICalculation calc : entry.calcs()) {
                    measures.addAll(calcMeasure().convert(calc));
                }
                return new Reading(entry.getDate(), measures);
            }
        };
    }
    private IConverter<ICalculation, Collection<IMeasure>> calcMeasure() {
        return new IConverter<ICalculation, Collection<IMeasure>>() {
            public Collection<IMeasure> convert(ICalculation entry) {
                Collection<IMeasure> measures = CollectionUtil.create();
                if(entry.getType().isElectricity()) {
                    if (entry.getVersion() == 1) {
                        measures.add(serviceFactory.createMeasure(MeasureType.ELECTRICITY,
                                ((MeasureCalc) entry).getCurrentMeasure()));
                    } else {
//                        measures.addAll(((ru.rrozhkov.easykin.model.service.calc2.impl.MeasureCalc) entry).getNewMeasures());
                    }
                }
                if (entry.getType().isWater()) {
                    if (entry.getVersion() == 1) {
                        measures.add(serviceFactory.createMeasure(MeasureType.COLDWATER, ((WaterCalc) entry).getColdCurrentMeasure(0)));
                        measures.add(serviceFactory.createMeasure(MeasureType.COLDWATER, ((WaterCalc) entry).getColdCurrentMeasure(1)));
                        measures.add(serviceFactory.createMeasure(MeasureType.HOTWATER, ((WaterCalc) entry).getHotCurrentMeasure(0)));
                        measures.add(serviceFactory.createMeasure(MeasureType.HOTWATER, ((WaterCalc) entry).getHotCurrentMeasure(1)));
                    } else {
//                        measures.addAll(((WaterCalc2) entry).getNewMeasures());
                    }
                }
                return measures;
            }
        };
    }
}
