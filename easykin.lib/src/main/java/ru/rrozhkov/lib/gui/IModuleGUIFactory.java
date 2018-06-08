package ru.rrozhkov.lib.gui;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public interface IModuleGUIFactory<T> {
    Component createTablePanel(IGUIEditor parent, Collection data);
    Component createEditor(IGUIEditor parent, T obj);
    Component createFilter(IGUIEditor parent);
}
