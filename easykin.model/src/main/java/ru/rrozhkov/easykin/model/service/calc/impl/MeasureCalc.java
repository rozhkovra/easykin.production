package ru.rrozhkov.easykin.model.service.calc.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;

import java.util.Collection;

public class MeasureCalc extends Calculation {
	private static final int VERSION = 1;
	protected Collection<Integer> prevMeasure;
	protected Collection<Integer> currentMeasure;
	protected Money rate;
	
	public MeasureCalc(Collection<Integer> prevMeasure, Collection<Integer> currentMeasure, Money rate, boolean isPaid, CalculationType type) {
		super(-1, -1, type, isPaid, rate, VERSION);
		this.prevMeasure = prevMeasure;
		this.currentMeasure = currentMeasure;
		this.rate = rate;
	}

	public MeasureCalc(int id, int readingId, IPayment payment, Collection<Integer> prevMeasure, Collection<Integer> currentMeasure, Money rate, CalculationType type) {
		super(id, readingId, type, payment);
		this.prevMeasure = prevMeasure;
		this.currentMeasure = currentMeasure;
		this.rate = rate;
	}

	public int getPrevMeasure(int i) {
		if (prevMeasure.size() - 1 < i) {
			throw new IndexOutOfBoundsException();
		}
		return CollectionUtil.get(prevMeasure, i);
	}

	public int getCurrentMeasure(int i) {
		if (currentMeasure.size() - 1 < i) {
			throw new IndexOutOfBoundsException();
		}
		return CollectionUtil.get(currentMeasure, i);
	}

	public int getPrevMeasure() {
		int result = 0;
		for (Integer measure : prevMeasure) {
			result+=measure;
		}
		return result;
	}

	public int getCurrentMeasure() {
		int result = 0;
		for (Integer measure : currentMeasure) {
			result+=measure;
		}
		return result;
	}
	public Money getRate() {
		return rate;
	}

	public void setPrevMeasure(Collection<Integer> prevMeasure) {
		this.prevMeasure = prevMeasure;
	}

	public void setCurrentMeasure(Collection<Integer> currentMeasure) {
		this.currentMeasure = currentMeasure;
	}

	public void setRate(Money rate) {
		this.rate = rate;
	}
}