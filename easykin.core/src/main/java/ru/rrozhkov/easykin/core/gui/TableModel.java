package ru.rrozhkov.easykin.core.gui;

import ru.rrozhkov.easykin.core.gui.style.ITableStyle;

import javax.swing.event.TableModelListener;
import java.util.Collection;

/**
 * Created by rrozhkov on 22.05.2018.
 */
public abstract class TableModel implements javax.swing.table.TableModel {
    protected Collection beans;
    protected ITableStyle style;

    public TableModel(Collection beans, ITableStyle style) {
        this.beans = beans;
        this.style = style;
    }

    public int getRowCount() {
        return beans.size();
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    public void addTableModelListener(TableModelListener l) {

    }

    public void removeTableModelListener(TableModelListener l) {

    }

    public int getColumnCount() {
        return style.getColumnCount();
    }

    public String getColumnName(int columnIndex) {
        return style.getColumnNames()[columnIndex];
    }

    public Collection getBeans() {
        return beans;
    }

    public ITableStyle getStyle() {
        return style;
    }
}
