package ru.rrozhkov.easykin.model.module.impl;

import ru.rrozhkov.easykin.model.module.IModule;
import ru.rrozhkov.easykin.model.module.IPerson2Module;

/**
 * Created by rrozhkov on 10.10.2018.
 */
public class ModuleFactory {
    public static class Holder {
        public static final ModuleFactory INSTANCE = new ModuleFactory();
    }

    public static ModuleFactory instance(){
        return Holder.INSTANCE;
    }

    private ModuleFactory() {
    }

    public IModule module(int id, String name) {
        return new Module(id, name);
    }

    public IPerson2Module person2Module(int id, int personId, int moduleId){
        return new Person2Module(id, personId, moduleId);
    }
}
