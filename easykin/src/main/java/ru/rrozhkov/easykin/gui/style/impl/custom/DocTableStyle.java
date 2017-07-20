package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.doc.IDoc;

import javax.swing.*;

/**
 * Created by rrozhkov on 3/13/2017.
 */
public class DocTableStyle extends TableStyle<IDoc> {
    public void setColumnStyles(JTable table) {
        super.setColumnStyles(table);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(50);
        table.getColumnModel().getColumn(1).setMinWidth(150);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(2).setMinWidth(150);
    }

    public String[] getColumnNames() {
        return new String[]{"№","ФИО","Документ"};
    }

    public int[] getColumnAlignment() {
        return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER};    }

}
