package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class AutoGUIFactory implements IModuleGUIFactory {
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new JPanel();
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new CarForm((ICar)obj);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
