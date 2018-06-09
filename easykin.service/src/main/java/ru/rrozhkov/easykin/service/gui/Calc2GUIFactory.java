package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Builder;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class Calc2GUIFactory implements IModuleGUIFactory<ServiceCalc> {
    final private static Calc2Builder calc2Builder = new Calc2Builder();
    protected final static IGUIFactory guiFactory = GUIFactory.create();

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new ServiceTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, ServiceCalc calc) {
        if(calc==null) {
            calc = (ServiceCalc)calc2Builder.buildNew();
        }
        return new ReadingServiceForm(parent, calc);

    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
