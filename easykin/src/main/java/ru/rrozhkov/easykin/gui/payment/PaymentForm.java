package ru.rrozhkov.easykin.gui.payment;

import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.util.DateUtil;

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
		setLayout(new GridLayout(6,2)); 		
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getCommentLabel()); 
		add(getCommentField()); 
		add(getAmountLabel()); 
		add(getAmountField()); 
		add(getDateLabel()); 
		add(getDateField());
		add(getCategoryLabel()); 
		add(getCategoryField());
		add(GuiUtil.labelEmpty());
		add(getCancelButton());
	}

	private Component getCommentField(){
		if(commentField == null){
			commentField = GuiUtil.fieldReadOnly(50, payment.getComment());
		}
		return commentField;
	}

	private Component getAmountField(){
		if(amountField == null){
			amountField = GuiUtil.fieldReadOnly(10, payment.getAmount().toString());
		}
		return amountField;
	}
	
	private Component getDateField(){
		if(dateField == null){
			dateField = GuiUtil.fieldReadOnly(10, DateUtil.format(payment.getDate()));
		}
		return dateField;
	}
	
	private Component getCategoryField(){
		if(categoryField == null){
			categoryField = GuiUtil.fieldReadOnly(50, payment.getCategory().toString());
		}
		return categoryField;
	}
	
	private Component getCommentLabel(){
		if(nameLabel == null)
			nameLabel = GuiUtil.label("Описание");
		return nameLabel;
	}
	
	private Component getAmountLabel(){
		if(priceLabel == null)
			priceLabel = GuiUtil.label("Цена");
		return priceLabel;
	}
	
	private Component getDateLabel(){
		if(dateLabel == null)
			dateLabel = GuiUtil.label("Дата");
		return dateLabel;
	}
	
	private Component getCategoryLabel(){
		if(categoryLabel == null)
			categoryLabel = GuiUtil.label("Категория");
		return categoryLabel;
	}
}