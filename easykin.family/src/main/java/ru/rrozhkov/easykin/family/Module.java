package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.family.gui.FamilyGUIFactory;
import ru.rrozhkov.easykin.family.service.impl.KinPersonService;
import ru.rrozhkov.easykin.model.family.IKinPerson;

import java.awt.Component;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory familyGUIFactory = FamilyGUIFactory.instance();
    private static final KinPersonService kinPersonService = KinPersonService.instance();

    public static Component createPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, kinPersonService.persons());
    }

    public static Component createKidsPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, kinPersonService.kids());
    }

    public static Component createEditor(IGUIEditor parent, IKinPerson person){
        return familyGUIFactory.createEditor(parent, person);
    }
}
