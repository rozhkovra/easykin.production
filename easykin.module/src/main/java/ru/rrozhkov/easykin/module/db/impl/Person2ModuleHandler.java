package ru.rrozhkov.easykin.module.db.impl;

import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;
import ru.rrozhkov.easykin.model.module.IPerson2Module;
import ru.rrozhkov.easykin.module.impl.convert.ModuleConverterFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class Person2ModuleHandler extends EntityHandler {
    final private static ModuleConverterFactory moduleConverterFactory = ModuleConverterFactory.instance();

    public static class Holder {
        public static final Person2ModuleHandler INSTANCE = new Person2ModuleHandler();
    }

    private Person2ModuleHandler() {
    }

    public static Person2ModuleHandler instance(){
        return Holder.INSTANCE;
    }

    public String selectForPerson = "SELECT * FROM "+getTableName()
            +" WHERE "+getTableName()+".PERSONID = #person#";

    @Override
    protected String getTableName() {
        return "person2module";
    }

    @Override
    protected IEntityConverter getConverter() {
        return moduleConverterFactory.person2module();
    }

    public Collection<IPerson2Module> selectForPerson(int id) throws Exception {
        return dbManager().select(selectForPerson.replace("#person#", String.valueOf(id)), getConverter());
    }
}
