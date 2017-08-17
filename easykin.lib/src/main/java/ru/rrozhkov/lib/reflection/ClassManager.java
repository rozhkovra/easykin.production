package ru.rrozhkov.lib.reflection;

import java.lang.reflect.Method;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class ClassManager {
    public static boolean exist(String clazz){
        try{
            Class.forName(clazz);
        }catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }

    public static Class clazz(String clazz){
        try{
            return Class.forName(clazz);
        }catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static Method method(Class clazz, String methodName, Class[] types) throws NoSuchMethodException {
        return clazz.getMethod(methodName, types);
    }
}
