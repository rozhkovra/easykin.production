package ru.rrozhkov.easykin.core.reflection;

import java.lang.reflect.Method;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class ClassManager {
    public boolean exist(String clazz){
        try{
            Class.forName(clazz);
        }catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public Class clazz(String clazz){
        try{
            return Class.forName(clazz);
        }catch (ClassNotFoundException e) {
            return null;
        }
    }

    public Method method(Class clazz, String methodName, Class[] types) throws NoSuchMethodException {
        return clazz.getMethod(methodName, types);
    }
    public Method method(Class clazz, String methodName) throws NoSuchMethodException {
        return clazz.getMethod(methodName);
    }
}
