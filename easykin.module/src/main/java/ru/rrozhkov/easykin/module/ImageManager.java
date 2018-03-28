package ru.rrozhkov.easykin.module;

import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 3/28/2018.
 */
public class ImageManager {
    public static ImageIcon finance(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/finance.png");
    }
    public static ImageIcon payment(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/payment.png");
    }
    public static ImageIcon family(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/family.png");
    }
    public static ImageIcon tasks(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/tasks.png");
    }
    public static ImageIcon work(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/work.png");
    }
    public static ImageIcon service(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/service.png");
    }

}
