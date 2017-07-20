package ru.rrozhkov.easykin.model.fin.payment.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;

import java.util.Date;

public class Payment implements IPayment {
	protected PaymentCategory category;
	protected String comment;
	protected Money amount;
	protected Date date;
	protected PaymentStatus status;
	
	public Payment(PaymentCategory category, String comment, Money amount, Date date, PaymentStatus status) {
		this.category = category;
		this.comment = comment;
		this.amount = amount;
		this.date = date;
		this.status = status;
	}

	public PaymentCategory getCategory() {
		return category;
	}

	public String getComment() {
		return comment;
	}

	public Money getAmount() {
		return amount;
	}

	public Date getDate() {
		return date;
	}

	public PaymentStatus getStatus() {
		return status;
	}
}