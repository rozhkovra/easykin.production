package ru.rrozhkov.easykin.resources;

import ru.rrozhkov.easykin.core.gui.util.ImageUtil;

import javax.swing.ImageIcon;
import java.awt.Image;

/**
 * Created by rrozhkov on 3/28/2018.
 */
public class ImageManager {
    public static class ImageManagerHolder {
        public static final ImageManager INSTANCE = new ImageManager();
    }

    public static ImageManager instance(){
        return ImageManagerHolder.INSTANCE;
    }

    public ImageIcon finance(Class clazz) {
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/finance.png"));
    }
    public ImageIcon payment(Class clazz) {
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/payment.png"));
    }
    public ImageIcon family(Class clazz) {
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/family.png"));
    }
    public ImageIcon tasks(Class clazz) {
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/tasks.png"));
    }
    public ImageIcon work(Class clazz) {
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/work.png"));
    }
    public ImageIcon service(Class clazz){
        return ImageUtil.scaleImage(25, 25, ImageUtil.imageIconByPath(clazz, "/icon/service.png"));
    }
    public Image serviceImg(Class clazz){
        return ImageUtil.imageByPath(clazz, "/icon/service.png");
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
    public Image keyImg(Class clazz){
        return ImageUtil.imageByPath(clazz, "/icon/key.png");
    }
    public ImageIcon exit(Class clazz){
        return ImageUtil.imageIconByPath(clazz, "/icon/exit.png");
    }

}
