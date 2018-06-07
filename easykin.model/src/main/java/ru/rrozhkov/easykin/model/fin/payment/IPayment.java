package ru.rrozhkov.easykin.model.fin.payment;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.lib.db.IEntity;

import java.util.Date;

public interface IPayment extends IEntity {
	int getId();
	PaymentCategory getCategory();
	String getComment();
	Money getAmount();
	Date getDate();
	PaymentStatus getStatus();
}