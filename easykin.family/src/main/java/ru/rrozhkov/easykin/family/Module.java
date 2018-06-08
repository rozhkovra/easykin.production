package ru.rrozhkov.easykin.family;

import ru.rrozhkov.easykin.family.gui.FamilyGUIFactory;
import ru.rrozhkov.easykin.family.impl.filter.KinFilterFactory;
import ru.rrozhkov.easykin.family.service.impl.KinPersonService;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.lib.filter.IFilter;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory familyGUIFactory = FamilyGUIFactory.instance();
    private static final KinPersonService kinPersonService = KinPersonService.instance();
    private static final KinFilterFactory kinFilterFactory = KinFilterFactory.instance();

    public static Component createPanel(IGUIEditor parent){
        return familyGUIFactory.createTablePanel(parent, kinPersonService.persons());
    }

    public static Component createKidsPanel(IGUIEditor parent){
        IFilter filter = kinFilterFactory.create(new KinType[]{KinType.SUN, KinType.DAUGHTER});
        return familyGUIFactory.createTablePanel(parent, kinPersonService.persons(filter));
    }

    public static Component createEditor(IGUIEditor parent, IKinPerson person){
        return familyGUIFactory.createEditor(parent, person);
    }
}
