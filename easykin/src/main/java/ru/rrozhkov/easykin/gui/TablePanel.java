package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.gui.listener.TableOnClickListener;

import javax.swing.*;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	public TablePanel(IGUIEditor parent, Table table) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(table.getTableHeader());
		JScrollPane js = new JScrollPane(table
				, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(js);
		table.getSelectionModel().addListSelectionListener(new TableOnClickListener(parent, table));
	}
}