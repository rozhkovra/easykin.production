package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;
import ru.rrozhkov.lib.util.DateUtil;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class ServiceGUIFactory implements IModuleGUIFactory<IService> {
    private final static IGUIFactory guiFactory = GUIFactory.create();
    private final static ServiceFactory serviceFactory = ServiceFactory.instance();

    public static class ServiceGUIFactoryHolder {
        public static final ServiceGUIFactory INSTANCE = new ServiceGUIFactory();
    }

    public static ServiceGUIFactory instance(){
        return ServiceGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new AutoTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, IService service) {
        return new AutoServiceForm(parent,service);
    }

    public Component createFilter(IGUIEditor parent) {
        IService service = serviceFactory.createService("", Money.valueOf(0.00), DateUtil.today());
        return new AutoServiceForm(parent,service);
    }
}
