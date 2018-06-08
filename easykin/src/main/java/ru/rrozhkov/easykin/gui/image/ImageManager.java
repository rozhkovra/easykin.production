package ru.rrozhkov.easykin.gui.image;

import ru.rrozhkov.lib.gui.util.ImageUtil;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class ImageManager {
    public static class ImageManagerHolder {
        public static final ImageManager INSTANCE = new ImageManager();
    }

    public static ImageManager instance(){
        return ImageManagerHolder.INSTANCE;
    }

    public Image logo(Class clazz){
        return ImageUtil.imageByPath(clazz, "/icon/logo.png");
    }
    public ImageIcon plus(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/plus.png");
    }
    public ImageIcon refresh(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/refresh1.png");
    }
    public ImageIcon filter(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/filter.png");
    }
    public ImageIcon dump(Class clazz) {
        return ImageUtil.imageIconByPath(clazz, "/icon/dump.png");
    }
    public ImageIcon key(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/key.png");
    }
    public ImageIcon exit(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/exit.png");
    }
}
