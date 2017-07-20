package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JLabel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.task.IComment;

public class CommentTableStyle extends TableStyle<IComment> {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.CENTER};
	}
	public String[] getColumnNames() {
		return new String[]{"№","Описание","Дата"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(400);
	    table.getColumnModel().getColumn(2).setMinWidth(100);
	    table.getColumnModel().getColumn(2).setMaxWidth(100);
	}
}