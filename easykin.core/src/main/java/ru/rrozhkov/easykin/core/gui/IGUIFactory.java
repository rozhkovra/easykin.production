package ru.rrozhkov.easykin.core.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
    Container panelEmpty();
    Container panel(LayoutManager manager);
    Container panelBordered();
    TablePanel tablePanel(IGUIEditor parent, Table table);
    TablePanel tablePanel(IGUIEditor parent, TableModel tableModel);
    Table table(TableModel tableModel);
    Component comboBoxFilled(Collection priorities);
    Component checkBox(String text);
    LayoutManager boxLayout(Container comp, int direction);
    LayoutManager gridLayout(int rows, int cols);
    Dimension size(int width, int height);
    JTabbedPane tabbedPane();
    JMenuItem menuItem(String text, Icon icon);
    JMenu menu(String text);
    JMenuBar menuBar();
    WindowEvent windowEvent(Window source, int id);
}
