package ru.rrozhkov.easykin.gui.util;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by rrozhkov on 3/1/2017.
 */
public class ImageUtil {
    public static ImageIcon scaleImage(int width, int height, ImageIcon imageIcon){
        Image newimg = imageIcon.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }

    public static ImageIcon imageIconByPath(Class clazz, String path){
        URL iconUrl = clazz.getResource(path);
        return new ImageIcon(iconUrl);
    }

    public static Image imageByPath(Class clazz, String path){
        URL iconUrl = clazz.getResource(path);
        return new ImageIcon(iconUrl).getImage();
    }
}
