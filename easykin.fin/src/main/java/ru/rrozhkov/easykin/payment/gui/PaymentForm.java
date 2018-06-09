package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.awt.*;

public class PaymentForm extends Form {
	private static final long serialVersionUID = 1L;
	private Component commentField;
	private Component amountField;
	private Component dateField;
	private Component nameLabel;
	private Component priceLabel;
	private Component dateLabel;
	private IPayment payment;
	private Component categoryField;
	private Component categoryLabel;
	
	public PaymentForm(IGUIEditor parent, IPayment payment) {
		super(parent);
		this.payment = payment;
		fill();
	}

	public PaymentForm(IGUIEditor parent) {
		this(parent, null);
	}

	
	protected void fill(){
		setLayout(guiFactory.gridLayout(6,2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getCommentLabel()); 
		add(getCommentField()); 
		add(getAmountLabel()); 
		add(getAmountField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(getCategoryLabel()); 
		add(getCategoryField());
		add(guiFactory.labelEmpty());
		add(getCancelButton());
	}

	private Component getCommentField(){
		if(commentField == null){
			commentField = guiFactory.fieldReadOnly(50, payment.getComment());
		}
		return commentField;
	}

	private Component getAmountField(){
		if(amountField == null){
			amountField = guiFactory.fieldReadOnly(10, payment.getAmount().toString());
		}
		return amountField;
	}
	
	private Component getDateField(){
		if(dateField == null){
			dateField = guiFactory.fieldReadOnly(10, DateUtil.format(payment.getDate()));
		}
		return dateField;
	}
	
	private Component getCategoryField(){
		if(categoryField == null){
			categoryField = guiFactory.fieldReadOnly(50, payment.getCategory().toString());
		}
		return categoryField;
	}
	
	private Component getCommentLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Описание");
		return nameLabel;
	}
	
	private Component getAmountLabel(){
		if(priceLabel == null)
			priceLabel = guiFactory.label("Цена");
		return priceLabel;
	}
	
	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = guiFactory.label("Дата");
		return dateLabel;
	}
	
	private Component getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = guiFactory.label("Категория");
		return categoryLabel;
	}
}