package ru.rrozhkov.easykin.service.calc.impl.convert;

import ru.rrozhkov.easykin.core.convert.IConverter;

/**
 * Created by rrozhkov on 15.06.2018.
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

    public IConverter serviceCalcConverter() {
        return new ServiceCalcConverter();
    }
}
