package ru.rrozhkov.easykin.module;

import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.reflection.ClassManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class ModuleManager {
    public static final String ROOT = "ru.rrozhkov.easykin";
    private static String module(String module){
        return ROOT+"." + module + ".Module";
    }
    public static boolean exist(String module){
        return ClassManager.exist(module(module));
    }
    public static Class clazz(String module){
        return ClassManager.clazz(module(module));
    }
    public static Object invoke(String module, String methodName, Object... params){
        Collection<Class> clazzs = CollectionUtil.create();
        for (Object obj : params){
            clazzs.add(getInterface(obj.getClass()));
        }
        Class clazz = ModuleManager.clazz(module);
        Method method = null;
        try {
            method = ClassManager.method(clazz, methodName, clazzs.toArray(new Class[clazzs.size()]));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
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

    private static Class getInterface(Class<? extends Object> aClass) {
        Class clazz = aClass;
        while(clazz.getInterfaces().length==0){
            clazz = clazz.getSuperclass();
        }
        return clazz.getInterfaces()[0];
    }

    public static void main(String[] args){
        System.out.println("Baby:"+ exist(Module.BABY));
        System.out.println("Auto:" + exist(Module.AUTO));
    }
}
