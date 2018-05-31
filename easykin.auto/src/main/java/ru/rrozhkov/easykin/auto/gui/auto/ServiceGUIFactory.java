package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceForm;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class ServiceGUIFactory implements IModuleGUIFactory {
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new TablePanel(parent, new Table(new AutoTableModel(data)));
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new AutoServiceForm(parent,(IService)obj);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
