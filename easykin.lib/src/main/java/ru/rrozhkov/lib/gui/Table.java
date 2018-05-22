package ru.rrozhkov.lib.gui;

import ru.rrozhkov.lib.collection.CollectionUtil;

import javax.swing.*;



public class Table extends JTable{
	private static final long serialVersionUID = 1L;

	protected TableModel model;

	public Table(TableModel model) {
		super(model);
		this.model = model;
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	@Override
	public void doLayout() {
		super.doLayout();
		model.getStyle().setColumnStyles(this);
		model.getStyle().setCellRenderer(this, model.getBeans());
	}

	@Override
	public String getColumnName(int col) {
	    return model.getStyle().getColumnNames()[col];
	}

	public Object currentData() {
		return CollectionUtil.get(model.getBeans(), getSelectedRow());
	}
}