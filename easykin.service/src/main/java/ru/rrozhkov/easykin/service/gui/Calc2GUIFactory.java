package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Builder;
import ru.rrozhkov.lib.gui.*;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class Calc2GUIFactory implements IModuleGUIFactory {
    final private static Calc2Builder calc2Builder = new Calc2Builder();
    protected final static IGUIFactory swingGuiFactory = GUIFactory.create();
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return swingGuiFactory.tablePanel(parent, (Table)swingGuiFactory.table(new ServiceTableModel(data)));
    }

    public JPanel createEditor(IGUIEditor parent, Object calc) {
        if(calc==null) {
            calc = calc2Builder.buildNew();
        }
        return new ReadingServiceForm(parent, (ServiceCalc)calc);

    }

    public JPanel createFilter(IGUIEditor parent) {
        return swingGuiFactory.panelEmpty();
    }
}
