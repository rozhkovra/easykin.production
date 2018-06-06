package ru.rrozhkov.easykin.module;

import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/28/2018.
 */
public class ImageManager {
    public ImageIcon finance(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/finance.png");
    }
    public ImageIcon payment(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/payment.png");
    }
    public ImageIcon family(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/family.png");
    }
    public ImageIcon tasks(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/tasks.png");
    }
    public ImageIcon work(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/work.png");
    }
    public ImageIcon service(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/service.png");
    }

}
