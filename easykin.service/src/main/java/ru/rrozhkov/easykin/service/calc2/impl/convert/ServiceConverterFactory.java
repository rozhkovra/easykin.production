package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ServiceConverterFactory {
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
    public IConverter calcReading() {return new CalcReadingConverter();}
    public IConverter calcMeasure() {return new CalculationMeasuresConverter();}
}
