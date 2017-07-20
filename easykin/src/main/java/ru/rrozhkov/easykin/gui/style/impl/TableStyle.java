package ru.rrozhkov.easykin.gui.style.impl;

import java.awt.Component;
import java.util.Collection;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import ru.rrozhkov.easykin.gui.style.ITableStyle;

public abstract class TableStyle<T> implements ITableStyle<T>{
	public void setColumnStyles(JTable table){
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}
	public void setCellRenderer(JTable table, final Collection<T> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        setHorizontalAlignment(getColumnAlignment()[column]);
		        return c;
		    }		    
		});
	}
	public int getColumnCount() {
		return getColumnNames().length;
	}
	
}