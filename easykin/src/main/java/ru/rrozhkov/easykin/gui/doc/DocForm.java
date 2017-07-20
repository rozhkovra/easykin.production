package ru.rrozhkov.easykin.gui.doc;

import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.lib.util.DateUtil;


import java.awt.*;

public class DocForm extends Form {
	private static final long serialVersionUID = 1L;
	private Component typeField;
	private Component numberField;
	private Component seriesField;
	private Component dateField;
	private Component typeLabel;
	private Component numberLabel;
	private Component seriesLabel;
	private Component dateLabel;
	private IDoc doc;

	public DocForm(IGUIEditor parent, IDoc doc) {
		super(parent);
		this.doc = doc;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(7, 2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getTypeLabel());
		add(getTypeField());
		add(getNumberLabel());
		add(getNumberField());
		add(getSeriesLabel());
		add(getSeriesField());
		add(getDateLabel());
		add(getDateField());
		add(GuiUtil.labelEmpty());
		add(getCancelButton());
	}

	private Component getTypeField(){
		if(typeField == null){
			typeField = GuiUtil.fieldReadOnly(50, doc.getDocType().toString());
		}
		return typeField;
	}

	private Component getNumberField(){
		if(numberField == null){
			numberField = GuiUtil.fieldReadOnly(50, doc.getNumber());
		}
		return numberField;
	}

	private Component getSeriesField(){
		if(seriesField == null){
			seriesField = GuiUtil.fieldReadOnly(50, doc.getSeries());
		}
		return seriesField;
	}

	private Component getDateField(){
		if(dateField == null){
			dateField = GuiUtil.fieldReadOnly(10, DateUtil.format(doc.getDate()));
		}
		return dateField;
	}

	private Component getTypeLabel(){
		if(typeLabel == null)
			typeLabel = GuiUtil.label("Тип");
		return typeLabel;
	}

	private Component getNumberLabel(){
		if(numberLabel == null)
			numberLabel = GuiUtil.label("Номер");
		return numberLabel;
	}

	private Component getSeriesLabel(){
		if(seriesLabel == null)
			seriesLabel = GuiUtil.label("Серия");
		return seriesLabel;
	}

	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = GuiUtil.label("Дата");
		return dateLabel;
	}
}