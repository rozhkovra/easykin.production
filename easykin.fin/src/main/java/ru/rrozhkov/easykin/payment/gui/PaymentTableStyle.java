package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;

import ru.rrozhkov.lib.gui.color.ColorManager;
import ru.rrozhkov.lib.gui.style.impl.TableStyle;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.Collection;

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
		table.getColumnModel().getColumn(2).setMinWidth(600);
	    table.getColumnModel().getColumn(3).setMinWidth(100);
	    table.getColumnModel().getColumn(3).setMaxWidth(100);
	    table.getColumnModel().getColumn(4).setMinWidth(150);
	    table.getColumnModel().getColumn(4).setMaxWidth(150);
		table.setRowHeight(30);
	}

	@Override
	public void setCellRenderer(JTable table, final Collection<IPayment> data) {
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				IPayment payment = (IPayment) ((java.util.List) data).get(row);
				if (PaymentStatus.FACT.equals(payment.getStatus())) {
					c.setBackground(ColorManager.done());
				} else {
					c.setBackground(ColorManager.open());
				}
				c.setFont(c.getFont().deriveFont(Font.PLAIN,18));
				setHorizontalAlignment(getColumnAlignment()[column]);
				return c;
			}

		});
	}
}