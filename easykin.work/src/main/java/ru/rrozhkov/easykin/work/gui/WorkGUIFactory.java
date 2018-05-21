package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;
import ru.rrozhkov.lib.gui.style.IStyle;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class WorkGUIFactory implements IGUIFactory{
    public JPanel createTablePanel(IGUIEditor parent, Collection data, IStyle style) {
        return new TablePanel(parent, new Table(data, style));
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        if(obj!=null) {
            return new ActivityForm(parent,(IActivity)obj);
        }
        return new ActivityForm(parent);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
