package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.family.gui.FamilyGUIFactory;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.family.service.impl.KinPersonService;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory familyGUIFactory = FamilyGUIFactory.instance();
    private static final KinPersonService kinPersonService = KinPersonService.instance();
    private static final KinFilterFactory kinFilterFactory = KinFilterFactory.instance();

    public static Component createPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, persons());
    }

    public static Component createKidsPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, kids());
    }

    public static Component createEditor(IGUIEditor parent, IKinPerson person){
        return familyGUIFactory.createEditor(parent, person);
    }

    private static Collection persons() {
        return kinPersonService.persons();
    }

    private static Collection kids() {
        IFilter filter = kinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER});
        return kinPersonService.persons(filter);
    }
}
