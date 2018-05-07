package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class ServiceConverterFactory {
    public static IEntityConverter measure(){return new MeasureConverter();}
    public static IEntityConverter reading(){return new ReadingConverter();}
    public static IEntityConverter rate(){return new RateConverter();}
}
