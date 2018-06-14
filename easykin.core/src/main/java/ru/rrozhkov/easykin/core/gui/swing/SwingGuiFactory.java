package ru.rrozhkov.easykin.core.gui.swing;

import ru.rrozhkov.easykin.core.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Collection;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class SwingGuiFactory implements IGUIFactory {
    public static class SwingGuiFactoryHolder {
        public static final SwingGuiFactory INSTANCE = new SwingGuiFactory();
    }

    public static SwingGuiFactory instance(){
        return SwingGuiFactoryHolder.INSTANCE;
    }
    public Component label(String text){
        return new JLabel(text);
    }
    public Component labelEmpty() {
        return new JLabel("");
    }
    public Component fieldReadOnly(int length, String text){
        JTextField field = new JTextField(length);
        field.setEditable(false);
        field.setText(text);
        return field;
    }
    public Component fieldEditable(int length, String text){
        JTextField field = new JTextField(length);
        field.setText(text);
        return field;
    }
    public Component fieldCalc(int length, String text, boolean readonly){
        if (!readonly) {
            return fieldEditable(length, text);
        }
        return fieldReadOnly(length, text);
    }
    public Component button(String text){
        return new JButton(text);
    }
    public Component button(String text, ActionListener listener){
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }
    public Component button(ImageIcon image, ActionListener listener){
        JButton button = new JButton(image);
        button.addActionListener(listener);
        return button;
    }
    public Component password(){
        return new JPasswordField();
    }
    public Container panelEmpty() {
        return new JPanel();
    }

    public Container panel(LayoutManager manager) {
        return new JPanel(manager);
    }
    public Container panelBordered() {
        return panel(new BorderLayout());
    }


    public TablePanel tablePanel(IGUIEditor parent, Table table) {
        return new TablePanel(parent, table);
    }

    public TablePanel tablePanel(IGUIEditor parent, TableModel tableModel) {
        return tablePanel(parent, table(tableModel));
    }

    public Table table(TableModel tableModel) {
        return new Table(tableModel);
    }

    public Component comboBoxFilled(Collection collection) {
        JComboBox box = new JComboBox();
        box.addItem("----");
        for(Object entry : collection){
            box.addItem(entry);
        }
        return box;
    }

    public Component checkBox(String text) {
        return new JCheckBox(text);
    }

    public LayoutManager boxLayout(Container comp, int direction) {
        return new BoxLayout(comp, direction);
    }

    public LayoutManager gridLayout(int rows, int cols) {
        return new GridLayout(rows, cols);
    }

    public Dimension size(int width, int height) {
        return new Dimension(width, height);
    }

    public JTabbedPane tabbedPane() {
        return new JTabbedPane();
    }

    public JMenuItem menuItem(String text, Icon icon) {
        return new JMenuItem(text, icon);
    }

    public JMenu menu(String text) {
        return new JMenu(text);
    }

    public JMenuBar menuBar() {
        return new JMenuBar();
    }

    public WindowEvent windowEvent(Window source, int id) {
        return new WindowEvent(source, id);
    }
}
