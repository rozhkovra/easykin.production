package ru.rrozhkov.easykin.gui.style.impl.custom;

import javax.swing.JLabel;
import javax.swing.JTable;

import ru.rrozhkov.easykin.gui.style.impl.TableStyle;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;

public class PaymentTableStyle extends TableStyle<IPayment> {
	public int[] getColumnAlignment() {
		return new int[]{JLabel.CENTER,JLabel.LEFT,JLabel.LEFT,JLabel.RIGHT,JLabel.CENTER};
	}
	public String[] getColumnNames() {
		return new String[]{"№","Категория","Описание","Сумма","Дата"};
	}
	
	public void setColumnStyles(JTable table){
	    super.setColumnStyles(table);
	    table.getColumnModel().getColumn(0).setMinWidth(50);
	    table.getColumnModel().getColumn(0).setMaxWidth(50);
	    table.getColumnModel().getColumn(1).setMinWidth(150);
	    table.getColumnModel().getColumn(1).setMaxWidth(200);
		table.getColumnModel().getColumn(2).setMinWidth(300);
	    table.getColumnModel().getColumn(3).setMinWidth(100);
	    table.getColumnModel().getColumn(3).setMaxWidth(100);
	    table.getColumnModel().getColumn(4).setMinWidth(100);
	    table.getColumnModel().getColumn(4).setMaxWidth(100);
	}
}