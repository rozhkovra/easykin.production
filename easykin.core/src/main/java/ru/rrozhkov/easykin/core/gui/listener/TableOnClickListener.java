package ru.rrozhkov.easykin.core.gui.listener;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.Table;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableOnClickListener implements ListSelectionListener {
	private IGUIEditor main;
	private Table table;
	
	public TableOnClickListener(IGUIEditor main, Table table) {
		this.main = main;
		this.table = table;
	}

	public void valueChanged(ListSelectionEvent arg0) {
		main.edit(table.currentData());
	}
}