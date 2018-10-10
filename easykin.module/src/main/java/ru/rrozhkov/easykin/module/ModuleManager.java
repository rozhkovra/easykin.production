package ru.rrozhkov.easykin.module;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.reflection.ClassManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class ModuleManager {
    private static final ClassManager classManager = new ClassManager();
    public static final String ROOT = "ru.rrozhkov.easykin";

    public static class Holder {
        public static final ModuleManager INSTANCE = new ModuleManager();
    }

    public static ModuleManager instance(){
        return Holder.INSTANCE;
    }

    public Collection<String> activeModules(){
        return CollectionUtil.create(Module.TASK,Module.FIN,Module.PAYMENT,Module.FAMILY, Module.WORK,Module.SERVICE, Module.JIRA);
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
