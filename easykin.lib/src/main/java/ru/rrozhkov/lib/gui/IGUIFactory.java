package ru.rrozhkov.lib.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public interface IGUIFactory {
    Component label(String text);
    Component labelEmpty();
    Component fieldReadOnly(int length, String text);
    Component fieldEditable(int length, String text);
    Component fieldCalc(int length, String text, boolean readonly);
    Component button(String text);
    Component button(String text, ActionListener listener);
    Component button(ImageIcon image, ActionListener listener);
    Component password();
    JPanel panelEmpty();
    JPanel tablePanel(IGUIEditor parent, Table table);
    JTable table(TableModel tableModel);

    JComboBox comboBoxFilled(Collection priorities);
}
