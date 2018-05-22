package ru.rrozhkov.lib.gui;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public interface IGUIFactory {
    JPanel createTablePanel(IGUIEditor parent, Collection data);
    JPanel createEditor(IGUIEditor parent, Object obj);
    JPanel createFilter(IGUIEditor parent);
}
