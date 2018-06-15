package ru.rrozhkov.easykin.model.fin.payment.impl;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;

import java.util.Date;

import static ru.rrozhkov.easykin.model.fin.payment.PaymentCategory.*;

public class PaymentFactory {
	public static class Holder {
		public static final PaymentFactory INSTANCE = new PaymentFactory();
	}

	public static PaymentFactory instance(){
		return Holder.INSTANCE;
	}

	private PaymentFactory() {
	}

	public IPayment createAutoPayment(String comment, Money amount, Date date){
		return createPayment(AUTO, comment,amount,date,PaymentStatus.FACT);
	}
	public IPayment createAutoRepairPayment(String comment, Money amount, Date date){
		return createPayment(AUTOREPAIR, comment,amount,date,PaymentStatus.FACT);
	}
	public IPayment createDetailPayment(String comment, Money amount, Date date){
		return createPayment(AUTODETAIL, comment,amount,date,PaymentStatus.FACT);
	}
	public IPayment createServiceCalcPayment(String comment, Money amount, Date date, boolean isPaid){
		if(isPaid)
			return createPayment(SERVICE, comment,amount,date,PaymentStatus.FACT);
		return createPayment(SERVICE, comment,amount,date,PaymentStatus.PLAN);
	}
	public IPayment createTaskPayment(String comment, Money amount, Date date, ru.rrozhkov.easykin.model.task.Status status){
		if(status.isClose())
			return createPayment(TASK, comment,amount,date,PaymentStatus.FACT);
		return createPayment(TASK, comment,amount,date,PaymentStatus.PLAN);
	}
	public IPayment createPayment(PaymentCategory category, String comment, Money amount, Date date, PaymentStatus status){
		return new Payment(category, comment,amount,date,status);
	}
	public IPayment createPayment(int id, PaymentCategory category, String comment, Money amount, Date date, PaymentStatus status){
		return new Payment(id, category, comment,amount,date,status);
	}
}