package ru.rrozhkov.easykin.work.gui;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.style.impl.TableStyle;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Collection;

public class ActivityTableStyle extends TableStyle<IActivity>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.LEFT};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Имя","Дата", "Часы", "Тип задачи", "ID задачи", "Номер релиза", "Коммментарий"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(200);
	    table.getColumnModel().getColumn(1).setPreferredWidth(250);
	    table.getColumnModel().getColumn(1).setMaxWidth(300);
	    table.getColumnModel().getColumn(2).setMinWidth(150);
	    table.getColumnModel().getColumn(2).setMaxWidth(200);
	    table.getColumnModel().getColumn(3).setMinWidth(100);
	    table.getColumnModel().getColumn(3).setMaxWidth(200);
	    table.getColumnModel().getColumn(4).setMinWidth(200);
	    table.getColumnModel().getColumn(4).setMaxWidth(300);
	    table.getColumnModel().getColumn(5).setMinWidth(100);
	    table.getColumnModel().getColumn(5).setMaxWidth(200);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(6).setMaxWidth(200);
		table.getColumnModel().getColumn(7).setMinWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(250);
		table.getColumnModel().getColumn(7).setMaxWidth(500);
		table.setRowHeight(40);
	}

	@Override
	public void setCellRenderer(JTable table, final Collection<IActivity> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setFont(c.getFont().deriveFont(Font.PLAIN,18));
				setHorizontalAlignment(getColumnAlignment()[column]);
				return c;
			}

		});
	}
}
