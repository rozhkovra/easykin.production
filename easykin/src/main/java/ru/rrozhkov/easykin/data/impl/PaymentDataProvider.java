package ru.rrozhkov.easykin.data.impl;

import ru.rrozhkov.easykin.auto.service.impl.convert.ServiceConverter;
import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.model.task.impl.convert.TaskPaymentConverter;
import ru.rrozhkov.lib.data.impl.CollectionDataProvider;

public class PaymentDataProvider extends CollectionDataProvider<IPayment> {
	public PaymentDataProvider(MasterDataContext context) {
		super(new ServiceConverter().convert(context.services()));
		this.collection.addAll(new ServiceCalcConverter().convert(context.calcs()));
		this.collection.addAll(new TaskPaymentConverter().convert(context.tasks()));
	}	
}