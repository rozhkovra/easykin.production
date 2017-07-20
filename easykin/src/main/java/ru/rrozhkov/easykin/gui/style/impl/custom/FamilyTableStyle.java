package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JLabel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.person.IPerson;

public class FamilyTableStyle extends TableStyle<IPerson> {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.LEFT,JLabel.LEFT,JLabel.CENTER};
	}
	
	public String[] getColumnNames() {
		return new String[]{"№","Фамилия","Имя","Отчество","Дата рождения"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
	    table.getColumnModel().getColumn(4).setMaxWidth(150);
	    table.getColumnModel().getColumn(4).setMinWidth(150);
	}
}