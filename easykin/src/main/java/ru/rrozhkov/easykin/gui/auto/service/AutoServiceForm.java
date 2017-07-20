package ru.rrozhkov.easykin.gui.auto.service;

import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.ServiceFactory;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.lib.util.DateUtil;

import java.awt.*;
import java.util.Date;

public class AutoServiceForm extends Form {
	private static final long serialVersionUID = 1L;
	private Component nameField;
	private Component priceField;
	private Component dateField;
	private Component nameLabel;
	private Component priceLabel;
	private Component dateLabel;
	private IService service;
	public AutoServiceForm(IGUIEditor parent, IService service) {
		super(parent);
		this.service = service;
		fill();
	}
	
	public AutoServiceForm(IGUIEditor parent) {
		this(parent, ServiceFactory.createService("", MoneyFactory.create(), new Date()));
	}
	
	protected void fill(){
		setLayout(new GridLayout(5,2)); 		
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getNameLabel()); 
		add(getNameField()); 
		add(getPriceLabel()); 
		add(getPriceField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(GuiUtil.labelEmpty());
		add(getCancelButton());
	}

	private Component getNameField(){
		if(nameField == null){
			nameField = GuiUtil.fieldReadOnly(50, service.getName());

		}
		return nameField;
	}

	private Component getPriceField(){
		if(priceField == null){
			priceField = GuiUtil.fieldReadOnly(10, service.getPrice().toString());
		}
		return priceField;
	}
	
	private Component getDateField(){
		if(dateField == null){
			dateField = GuiUtil.fieldReadOnly(10, DateUtil.format(service.getDate()));
		}
		return dateField;
	}
	
	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = GuiUtil.label("Описание");
		return nameLabel;
	}
	
	private Component getPriceLabel(){
		if(priceLabel == null)
			priceLabel = GuiUtil.label("Цена");
		return priceLabel;
	}
	
	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = GuiUtil.label("Дата");
		return dateLabel;
	}
}