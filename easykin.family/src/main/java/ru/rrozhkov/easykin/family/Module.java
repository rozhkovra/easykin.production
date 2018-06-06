package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.family.db.impl.KinPersonHandler;
import ru.rrozhkov.easykin.family.gui.FamilyGUIFactory;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory familyGUIFactory = new FamilyGUIFactory();
    public static Component createPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, persons());
    }

    private static Collection persons() {
        Collection collection = null;
        try {
            collection = KinPersonHandler.select();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static Collection persons(IFilter filter) {
        return FilterUtil.filter(persons(), filter);
    }

    public static Component createKidsPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, persons(KinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER})));
    }

    public static Component createEditor(IGUIEditor parent, IKinPerson person){
        return familyGUIFactory.createEditor(parent, person);
    }
}
