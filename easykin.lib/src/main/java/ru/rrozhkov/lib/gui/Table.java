package ru.rrozhkov.lib.gui;

import ru.rrozhkov.lib.gui.style.IStyle;

import java.util.Collection;

import javax.swing.JTable;



public class Table extends JTable{
	private static final long serialVersionUID = 1L;
	
	protected IStyle style;
	protected Collection data;
	
	public Table(Collection data, IStyle style) {
		super(style.dataConverter().convert(data)
				,style.tableStyle().getColumnNames());
		this.style = style;
		this.data = data;
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	}

	@Override
	public void doLayout() {
		super.doLayout();
		style.tableStyle().setColumnStyles(this);
		style.tableStyle().setCellRenderer(this, data);
	}
		
	@Override
	public String getColumnName(int col) {
	    return style.tableStyle().getColumnNames()[col];
	}
}