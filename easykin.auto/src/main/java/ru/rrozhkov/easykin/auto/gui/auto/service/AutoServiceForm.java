package ru.rrozhkov.easykin.auto.gui.auto.service;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.awt.Component;

public class AutoServiceForm extends Form {
	private static final long serialVersionUID = 1L;
	private Component nameField;
	private Component priceField;
	private Component dateField;
	private Component nameLabel;
	private Component priceLabel;
	private Component dateLabel;
	private IService service;

	public static Form create(final IGUIEditor parent, final IService service) {
		Form form = new AutoServiceForm(parent, service);
		form.fill();
		return form;
	}

	private AutoServiceForm(final IGUIEditor parent, final IService service) {
		super(parent);
		this.service = service;
	}

	public void fill(){
		setLayout(guiFactory.gridLayout(5,2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPriceLabel()); 
		add(getPriceField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(guiFactory.labelEmpty());
		add(getCancelButton());
	}

	private Component getNameField(){
		if(nameField == null){
			nameField = guiFactory.fieldReadOnly(50, service.getName());

		}
		return nameField;
	}

	private Component getPriceField(){
		if(priceField == null){
			priceField = guiFactory.fieldReadOnly(10, service.getPrice().toString());
		}
		return priceField;
	}
	
	private Component getDateField(){
		if(dateField == null){
			dateField = guiFactory.fieldReadOnly(10, DateUtil.format(service.getDate()));
		}
		return dateField;
	}
	
	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Описание");
		return nameLabel;
	}
	
	private Component getPriceLabel(){
		if(priceLabel == null)
			priceLabel = guiFactory.label("Цена");
		return priceLabel;
	}
	
	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = guiFactory.label("Дата");
		return dateLabel;
	}
}