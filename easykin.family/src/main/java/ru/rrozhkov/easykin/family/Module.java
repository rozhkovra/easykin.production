package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.family.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.family.gui.FamilyGUIFactory;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory familyGUIFactory = new FamilyGUIFactory();
    public static JPanel createPanel(IGUIEditor parent){
        Collection collection = null;
        try {
            collection = KinPersonHandler.select();
            return familyGUIFactory.createTablePanel(parent, collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JPanel createKidsPanel(IGUIEditor parent){
        Collection collection = null;
        try {
            collection = FilterUtil.filter(KinPersonHandler.select(), KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER}));
            return familyGUIFactory.createTablePanel(parent, collection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JPanel createEditor(IGUIEditor parent, IKinPerson person){
        return familyGUIFactory.createEditor(parent, person);
    }
}
