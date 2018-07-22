package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.PaymentCategory;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.model.fin.payment.impl.Payment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

public abstract class DoubleSimpleCalc extends SimpleCalc {
	protected double prevMeasure2;
	protected double currentMeasure2;

	public DoubleSimpleCalc(double prevMeasure2, double currentMeasure2,
							double prevMeasure, double currentMeasure,
							Money rate, boolean isPaid, CalculationType type) {
		super(prevMeasure, currentMeasure,rate, isPaid, type);
		this.prevMeasure2 = prevMeasure2;
		this.currentMeasure2 = currentMeasure2;
	}

	public DoubleSimpleCalc(int id, int readingId,
							double prevMeasure2, double currentMeasure2,
							double prevMeasure, double currentMeasure,
							Money rate, boolean isPaid, CalculationType type) {
		super(id, readingId,
				PaymentFactory.instance().createPayment(PaymentCategory.SERVICE, "", rate, DateUtil.today(), isPaid?PaymentStatus.FACT:PaymentStatus.PLAN),
				prevMeasure, currentMeasure, rate, type);
		this.prevMeasure2 = prevMeasure2;
		this.currentMeasure2 = currentMeasure2;
	}
	
	public double getPrevMeasure2() {
		return prevMeasure2;
	}
	public double getCurrentMeasure2() {
		return currentMeasure2;
	}

	public void setPrevMeasure2(double prevMeasure2) {
		this.prevMeasure2 = prevMeasure2;
	}

	public void setCurrentMeasure2(double currentMeasure2) {
		this.currentMeasure2 = currentMeasure2;
	}
}