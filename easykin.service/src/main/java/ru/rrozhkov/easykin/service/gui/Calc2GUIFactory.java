package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Builder;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class Calc2GUIFactory implements IModuleGUIFactory {
    final private static Calc2Builder calc2Builder = new Calc2Builder();
    protected final static IGUIFactory guiFactory = GUIFactory.create();
    
    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new ServiceTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, Object calc) {
        if(calc==null) {
            calc = calc2Builder.buildNew();
        }
        return new ReadingServiceForm(parent, (ServiceCalc)calc);

    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
