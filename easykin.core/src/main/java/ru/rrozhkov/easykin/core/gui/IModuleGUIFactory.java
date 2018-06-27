package ru.rrozhkov.easykin.core.gui;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public interface IModuleGUIFactory<T> {
    Component createTablePanel(IGUIEditor parent, Collection data);
    Component createEditor(IGUIEditor parent, T obj);
    Component createView(IGUIEditor parent, T obj);
    Component createFilter(IGUIEditor parent);
}
