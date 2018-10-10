package ru.rrozhkov.easykin.module.impl.convert;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class ModuleConverterFactory {
    public static class Holder {
        public static final ModuleConverterFactory INSTANCE = new ModuleConverterFactory();
    }

    public static ModuleConverterFactory instance(){
        return Holder.INSTANCE;
    }

    private ModuleConverterFactory() {
    }

    public IEntityConverter module() {return new ModuleConverter();}
    public IEntityConverter person2module() {
        return new Person2ModuleConverter();
    }
}
