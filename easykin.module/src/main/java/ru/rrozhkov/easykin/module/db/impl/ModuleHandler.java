package ru.rrozhkov.easykin.module.db.impl;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.module.impl.convert.ModuleConverterFactory;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class ModuleHandler extends EntityHandler {
    final private static ModuleConverterFactory moduleConverterFactory = ModuleConverterFactory.instance();

    public static class Holder {
        public static final ModuleHandler INSTANCE = new ModuleHandler();
    }

    private ModuleHandler() {
    }

    public static ModuleHandler instance(){
        return Holder.INSTANCE;
    }

    @Override
    protected String getTableName() {
        return "module";
    }

    @Override
    protected IEntityConverter getConverter() {
        return moduleConverterFactory.module();
    }
}
