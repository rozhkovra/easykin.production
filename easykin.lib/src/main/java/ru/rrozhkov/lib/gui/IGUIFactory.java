package ru.rrozhkov.lib.gui;

import ru.rrozhkov.lib.gui.style.IStyle;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public interface IGUIFactory {
    JPanel createTablePanel(IGUIEditor parent, Collection data, IStyle style);
    JPanel createEditor(IGUIEditor parent, Object obj);
    JPanel createFilter(IGUIEditor parent);
}
