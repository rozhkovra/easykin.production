package ru.rrozhkov.easykin.work.impl.convert;

import ru.rrozhkov.lib.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class WorkConverterFactory {
    public static class WorkConverterFactoryHolder {
        public static final WorkConverterFactory INSTANCE = new WorkConverterFactory();
    }

    public static WorkConverterFactory instance(){
        return WorkConverterFactoryHolder.INSTANCE;
    }

    public IEntityConverter activity(){return new ActivityConverter();}
}
