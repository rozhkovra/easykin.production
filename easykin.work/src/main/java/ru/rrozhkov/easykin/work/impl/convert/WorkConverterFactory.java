package ru.rrozhkov.easykin.work.impl.convert;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 07.05.2018.
 */
public class WorkConverterFactory {
    private static class Holder {
        private static final WorkConverterFactory INSTANCE = new WorkConverterFactory();
    }

    public static WorkConverterFactory instance(){
        return Holder.INSTANCE;
    }

    private WorkConverterFactory() {
    }

    public IEntityConverter activity(){return new ActivityConverter();}
}
