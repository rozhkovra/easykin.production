package ru.rrozhkov.easykin.model.fin.payment;

import ru.rrozhkov.easykin.model.fin.Money;

import java.util.Date;

public interface IPayment {
	PaymentCategory getCategory();
	String getComment();
	Money getAmount();
	Date getDate();
	PaymentStatus getStatus();
}