package ru.rrozhkov.easykin.auto.service.impl.convert;

import java.util.Collection;

import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.RepairService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;

public class ServiceConverter implements IConverter<Collection<IService>,Collection<IPayment>> {
	final static private PaymentFactory paymentFactory = PaymentFactory.instance();
	private static final PaymentFilterFactory paymentFilterFactory = PaymentFilterFactory.instance();

	public Collection<IPayment> convert(Collection<IService> entries) {
		Collection<IPayment> collection = CollectionUtil.create();
		for(IService service : entries){
			collection.add(new SingleConverter().convert(service));
			for(IService detailService : service.services()){
				collection.add(paymentFactory.createDetailPayment(detailService.getName(), detailService.getPrice(), detailService.getDate()));
			}
		}
		return FilterUtil.filter(collection, paymentFilterFactory.noFree());
	}
	
	class SingleConverter implements IConverter<IService, IPayment> {
		public IPayment convert(IService entry) {
			if(entry instanceof RepairService){
				return paymentFactory.createAutoRepairPayment(entry.getName(),entry.getPrice(),entry.getDate());
			}
			return paymentFactory.createAutoPayment(entry.getName(),entry.getPrice(),entry.getDate());
		}
	}
}