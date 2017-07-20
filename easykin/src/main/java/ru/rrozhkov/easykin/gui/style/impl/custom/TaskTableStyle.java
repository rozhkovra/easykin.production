package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.color.ColorManager;
import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class TaskTableStyle extends TableStyle<ITask>  {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER,JLabel.CENTER};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Описание","Выполнить до", "Приоритет", "Категория", "Дата"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(200);
	    table.getColumnModel().getColumn(1).setPreferredWidth(500);
	    table.getColumnModel().getColumn(1).setMaxWidth(1000);
	    table.getColumnModel().getColumn(2).setMinWidth(100);
	    table.getColumnModel().getColumn(2).setMaxWidth(200);
	    table.getColumnModel().getColumn(3).setMinWidth(150);
	    table.getColumnModel().getColumn(3).setMaxWidth(200);
	    table.getColumnModel().getColumn(4).setMinWidth(100);
	    table.getColumnModel().getColumn(4).setMaxWidth(200);
	    table.getColumnModel().getColumn(5).setMinWidth(100);
	    table.getColumnModel().getColumn(5).setMaxWidth(200);
	    table.setRowHeight(40);
	}

	@Override
	public void setCellRenderer(JTable table, final Collection<ITask> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
		{
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
		    {
		        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        ITask task = (ITask) ((List)data).get(row);		        		
		        if(Status.CLOSE.equals(task.getStatus())){
		        	if(task.getCloseDate().getTime()>task.getPlanDate().getTime())
		        		c.setBackground(ColorManager.expired());
		        	else
		        		c.setBackground(ColorManager.done());
		        }else{
	        		c.setBackground(ColorManager.simple());
		        	if(Priority.IMPOTANT_FAST.equals(task.getPriority())
		        			|| Priority.IMPOTANT_NOFAST.equals(task.getPriority())){
		        		c.setBackground(ColorManager.open());
		        		if(new Date().getTime()>task.getPlanDate().getTime()
		        				&& column==5)
		        			c.setBackground(ColorManager.expired());
		        	}
		        }
		        if (Priority.IMPOTANT_FAST.equals(task.getPriority())){
		           c.setFont(c.getFont().deriveFont(Font.BOLD,18));
		           
		        } else {  
	        	   c.setFont(c.getFont().deriveFont(Font.PLAIN,15));
		        }
		        setHorizontalAlignment(getColumnAlignment()[column]);
		        return c;
		    }
		    
		});
	}
}
