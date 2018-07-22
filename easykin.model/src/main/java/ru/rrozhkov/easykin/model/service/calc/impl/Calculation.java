package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import java.util.Date;

public class Calculation implements ICalculation {
	private int id;
	private boolean isPaid = false;
	private int readingId;
	private Money amount;
	private IPayment payment;
	private CalculationType type;
	private Date payDate = DateUtil.today();

	public Calculation(int id, int readingId, CalculationType type, boolean isPaid, Money amount) {
		this.id = id;
		this.isPaid = isPaid;
		this.readingId = readingId;
		this.amount = amount;
		this.type = type;
	}

	public Calculation(int id, int readingId, CalculationType type, IPayment payment) {
		this.id = id;
		this.isPaid = payment.getStatus().isFact();
		this.readingId = readingId;
		this.amount = payment.getAmount();
		this.payment = payment;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReadingId() {
		return readingId;
	}

	public void setReadingId(int readingId) {
		this.readingId = readingId;
	}

	public boolean isPaid() {return isPaid;}

	public void setPaid(boolean isPaid) {this.isPaid = isPaid;}

	public Money getAmount() {
		return amount;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

	public CalculationType getType() {
		return type;
	}

	public void setType(CalculationType type) {
		this.type = type;
	}

	@Override
	public Calculation clone() throws CloneNotSupportedException {
		Calculation calculation = (Calculation)super.clone();
		calculation.setId(-1);
		return calculation;
	}

}