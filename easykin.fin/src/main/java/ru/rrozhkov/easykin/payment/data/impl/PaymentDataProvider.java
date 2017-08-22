package ru.rrozhkov.easykin.payment.data.impl;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

import java.util.ArrayList;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	public PaymentDataProvider() {
		super(new ArrayList<IPayment>());
	}	
}