package ru.rrozhkov.easykin.module;

import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    final static private ImageManager imageManager = new ImageManager();
    // First level
    public static final String PERSON = "person";
    public static final String FAMILY = "family";
    public static final String FIN = "fin";
    public static final String SERVICE = "service";
    public static final String TASK = "task";
    public static final String PAYMENT = "payment";

    // Second level
    public static final String WORK = "work";
    public static final String MESSAGE = "message";
    public static final String EMAIL = "email";
    public static final String DEVELOPMENT = "development";

    // Third level
    public static final String BABY = "baby";
    public static final String SCHOOL = "school";
    public static final String GOVERNMENT = "covernment";
    public static final String MEDICAL = "medical";
    public static final String AUTO = "auto";
    public static final String NOTE = "note";

    public static final Map<String, String> module2name = new HashMap<String, String>() {
        {
            put(AUTO, "Машина");
            put(PERSON, "Человек");
            put(FAMILY, "Семья");
            put(FIN, "Финансы");
            put(PAYMENT, "Платежи");
            put(SERVICE, "Коммунальные услуги");
            put(TASK, "Задачи");
            put(WORK, "Работа");
        }
    };
    public static final Map<String, String> name2module = new HashMap<String, String>() {
        {
            put("Машина", AUTO);
            put("Человек", PERSON);
            put("Семья", FAMILY);
            put("Финансы", FIN);
            put("Платежи", PAYMENT);
            put("Коммунальные услуги", SERVICE);
            put("Задачи", TASK);
            put("Работа", WORK);
        }
    };

    public static final Map<String, ImageIcon> module2icon = new HashMap<String, ImageIcon>() {
        {
            put(AUTO, null);
            put(PERSON, null);
            put(FAMILY, ImageUtil.scaleImage(25,25,imageManager.family(getClass())));
            put(FIN, ImageUtil.scaleImage(25,25,imageManager.finance(getClass())));
            put(PAYMENT, ImageUtil.scaleImage(25, 25, imageManager.payment(getClass())));
            put(SERVICE, ImageUtil.scaleImage(25, 25, imageManager.service(getClass())));
            put(TASK, ImageUtil.scaleImage(25, 25, imageManager.tasks(getClass())));
            put(WORK, ImageUtil.scaleImage(25, 25, imageManager.work(getClass())));
        }
    };
    public static String name(String module){
        return module2name.get(module);
    }
    public static ImageIcon icon(String module){
        return module2icon.get(module);
    }
    public static String mod(String name){
        return name2module.get(name);
    }
}
