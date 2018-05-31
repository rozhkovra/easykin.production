package ru.rrozhkov.lib.gui.swing;

import ru.rrozhkov.lib.gui.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 * Created by rrozhkov on 3/3/2017.
 */
public class SwingGuiFactory implements IGUIFactory {
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
    public JPanel panelEmpty() {
        return new JPanel();
    }
    public JPanel tablePanel(IGUIEditor parent, Table table) {
        return new TablePanel(parent, table);
    }
    public JTable table(TableModel tableModel) {
        return new Table(tableModel);
    }

    public JComboBox comboBoxFilled(Collection collection) {
        JComboBox box = new JComboBox();
        box.addItem("----");
        for(Object entry : collection){
            box.addItem(entry);
        }
        return box;
    }
}
