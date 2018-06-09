package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ServiceConverterFactory {
    public IEntityConverter measure(){return new MeasureConverter();}
    public IEntityConverter reading(){return new ReadingConverter();}
    public IEntityConverter rate(){return new RateConverter();}
}
