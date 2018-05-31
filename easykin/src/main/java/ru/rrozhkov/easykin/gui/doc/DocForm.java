package ru.rrozhkov.easykin.gui.doc;

import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
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
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getTypeLabel());
		add(getTypeField());
		add(getNumberLabel());
		add(getNumberField());
		add(getSeriesLabel());
		add(getSeriesField());
		add(getDateLabel());
		add(getDateField());
		add(guiFactory.labelEmpty());
		add(getCancelButton());
	}

	private Component getTypeField(){
		if(typeField == null){
			typeField = guiFactory.fieldReadOnly(50, doc.getDocType().toString());
		}
		return typeField;
	}

	private Component getNumberField(){
		if(numberField == null){
			numberField = guiFactory.fieldReadOnly(50, doc.getNumber());
		}
		return numberField;
	}

	private Component getSeriesField(){
		if(seriesField == null){
			seriesField = guiFactory.fieldReadOnly(50, doc.getSeries());
		}
		return seriesField;
	}

	private Component getDateField(){
		if(dateField == null){
			dateField = guiFactory.fieldReadOnly(10, DateUtil.format(doc.getDate()));
		}
		return dateField;
	}

	private Component getTypeLabel(){
		if(typeLabel == null)
			typeLabel = guiFactory.label("Тип");
		return typeLabel;
	}

	private Component getNumberLabel(){
		if(numberLabel == null)
			numberLabel = guiFactory.label("Номер");
		return numberLabel;
	}

	private Component getSeriesLabel(){
		if(seriesLabel == null)
			seriesLabel = guiFactory.label("Серия");
		return seriesLabel;
	}

	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = guiFactory.label("Дата");
		return dateLabel;
	}
}