package ru.rrozhkov.easykin.module;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.reflection.ClassManager;
import ru.rrozhkov.easykin.model.module.IModule;
import ru.rrozhkov.easykin.model.module.IPerson2Module;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.module.db.impl.ModuleHandler;
import ru.rrozhkov.easykin.module.db.impl.Person2ModuleHandler;
import ru.rrozhkov.easykin.person.auth.AuthManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class ModuleManager {
    private static final ClassManager classManager = new ClassManager();
    public static final String ROOT = "ru.rrozhkov.easykin";
    private static final AuthManager authManager = AuthManager.instance();
    private static final Person2ModuleHandler person2ModuleHandler = Person2ModuleHandler.instance();
    private static final ModuleHandler moduleHandler = ModuleHandler.instance();

    private Collection<String> activeModules = CollectionUtil.create();

    public static class Holder {
        public static final ModuleManager INSTANCE = new ModuleManager();
    }

    public static ModuleManager instance(){
        return Holder.INSTANCE;
    }

    public Collection<String> activeModules(){
        if (activeModules.isEmpty()) {
            IPerson person = authManager.signedPerson();
            try {
                Collection<IPerson2Module> person2Modules = person2ModuleHandler.selectForPerson(person.getId());
                for (IPerson2Module person2Module : person2Modules) {
                    Collection<IModule> modules = moduleHandler.selectForId(person2Module.getModuleId());
                    if(!modules.isEmpty()) {
                        IModule module = CollectionUtil.get(modules, 0);
                        activeModules.add(module.getName());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return activeModules;
    }
    private String moduleClass(String module){
        return ROOT+"." + module + ".Module";
    }
    public boolean isActive(String module) {
        return activeModules().contains(module);
    }
    public boolean exist(String module){
        return classManager.exist(moduleClass(module));
    }
    public Object invoke(String module, String methodName, Object... params){
        Collection<Class> clazzs = CollectionUtil.create();
        for (Object obj : params){
            clazzs.add(getInterface(obj.getClass()));
        }
        Class clazz = classManager.clazz(moduleClass(module));
        Method method;
        try {
            method = classManager.method(clazz, methodName, clazzs.toArray(new Class[clazzs.size()]));
        } catch (NoSuchMethodException e) {
            return null;
        }

        try {
            return method.invoke(null, params);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Object invoke(String module, String methodName){
        Class clazz = classManager.clazz(moduleClass(module));
        Method method = null;
        try {
            method = classManager.method(clazz, methodName);
        } catch (NoSuchMethodException e) {
            return null;
        }

        try {
            return method.invoke(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Class getInterface(Class<? extends Object> aClass) {
        Class clazz = aClass;
        while(clazz.getInterfaces().length==0){
            clazz = clazz.getSuperclass();
        }
        return clazz.getInterfaces()[0];
    }
}
