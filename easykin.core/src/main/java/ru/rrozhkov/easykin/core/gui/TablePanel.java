package ru.rrozhkov.easykin.core.gui;

import ru.rrozhkov.easykin.core.gui.listener.TableOnClickListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TablePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected final static IGUIFactory guiFactory = GUIFactory.create();
	public TablePanel(IGUIEditor parent, Table table) {
		super();
		setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
		add(table.getTableHeader());
		JScrollPane js = new JScrollPane(table
				, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED
				, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(js);
		table.getSelectionModel().addListSelectionListener(new TableOnClickListener(parent, table));
	}
}