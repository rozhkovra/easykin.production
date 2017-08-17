package ru.rrozhkov.lib.gui.listener;

import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;

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