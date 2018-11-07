package ru.rrozhkov.easykin.module.db.impl;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.module.IModule;
import ru.rrozhkov.easykin.module.impl.convert.ModuleConverterFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class ModuleHandler extends EntityHandler {
    final private static ModuleConverterFactory moduleConverterFactory = ModuleConverterFactory.instance();
    public String selectForId = "SELECT * FROM "+getTableName()
            +" WHERE "+getTableName()+".ID = #id#";

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

    public Collection<IModule> selectForId(int id) throws Exception {
        return dbManager().select(selectForId.replace("#id#", String.valueOf(id)), getConverter());
    }
}
