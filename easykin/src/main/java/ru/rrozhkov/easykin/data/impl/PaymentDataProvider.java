package ru.rrozhkov.easykin.data.impl;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.convert.FinConverterFactory;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	public PaymentDataProvider(MasterDataContext context) {
		super(FinConverterFactory.createServiceConverter().convert(context.services()));
		this.collection.addAll(FinConverterFactory.createServiceCalcConverter().convert(context.calcs()));
		this.collection.addAll(FinConverterFactory.createTaskConverter().convert(context.tasks()));
	}	
}