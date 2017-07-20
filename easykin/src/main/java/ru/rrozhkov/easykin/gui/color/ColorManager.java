package ru.rrozhkov.easykin.gui.color;

import java.awt.*;

/**
 * Created by rrozhkov on 3/6/2017.
 */
public class ColorManager {
    private static Color green(){
        return new Color(102, 255, 102);
    }
    private static Color yellow(){
        return new Color(255, 255, 102);
    }
    private static Color gray(){
        return new Color(192, 192, 192);
    }
    private static Color white(){
        return new Color(255, 255, 255);
    }
    public static Color done(){
        return green();
    }
    public static Color open(){
        return yellow();
    }
    public static Color expired(){
        return gray();
    }
    public static Color simple(){
        return white();
    }
}
