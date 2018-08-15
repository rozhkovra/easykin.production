package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc2.impl.Service2Builder;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.service.gui.reading.ReadingCalcPanel;
import ru.rrozhkov.easykin.service.gui.reading.ReadingServiceForm;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class Calc2GUIFactory implements IModuleGUIFactory<ServiceCalc> {
    private static final Service2Builder calc2Builder = Service2Builder.instance();
    private static final IGUIFactory guiFactory = GUIFactory.create();

    public static class Holder {
        public static final Calc2GUIFactory INSTANCE = new Calc2GUIFactory();
    }

    public static Calc2GUIFactory instance(){
        return Holder.INSTANCE;
    }

    private Calc2GUIFactory() {
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new ServiceTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, ServiceCalc calc) {
        if(calc==null) {
            calc = (ServiceCalc)calc2Builder.buildNew();
        }
        return ReadingServiceForm.create(parent, calc);

    }

    public Component createView(IGUIEditor parent, ServiceCalc calc) {
        return ReadingCalcPanel.create((Panel)parent, calc);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
