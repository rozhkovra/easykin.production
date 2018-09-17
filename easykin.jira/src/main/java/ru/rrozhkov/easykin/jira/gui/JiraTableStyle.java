package ru.rrozhkov.easykin.jira.gui;

import ru.rrozhkov.easykin.core.gui.color.ColorManager;
import ru.rrozhkov.easykin.core.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.jira.JiraTask;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Component;
import java.awt.Font;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class JiraTableStyle extends TableStyle<JiraTask>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Описание", "Статус"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(200);
	    table.getColumnModel().getColumn(1).setPreferredWidth(1000);
	    table.getColumnModel().getColumn(1).setMaxWidth(1500);
	    table.getColumnModel().getColumn(2).setMinWidth(300);
	    table.getColumnModel().getColumn(2).setMaxWidth(500);
	    table.setRowHeight(40);
	}


	@Override
	public void setCellRenderer(JTable table, final Collection<JiraTask> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				c.setFont(c.getFont().deriveFont(Font.BOLD, 18));
				setHorizontalAlignment(getColumnAlignment()[column]);
				return c;
			}

		});
	}
}
