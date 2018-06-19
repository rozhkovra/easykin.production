package ru.rrozhkov.easykin.auto.service.impl.convert;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.auto.service.impl.RepairService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;

import java.util.Collection;

/**
 * Created by rrozhkov on 19.06.2018.
 */
public class ServiceConverterFactory {
    private static final PaymentFactory paymentFactory = PaymentFactory.instance();
    private static final PaymentFilterFactory paymentFilterFactory = PaymentFilterFactory.instance();

    public static class Holder {
        public static final ServiceConverterFactory INSTANCE = new ServiceConverterFactory();
    }

    public static ServiceConverterFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceConverterFactory() {
    }

    public IConverter serviceCollectionConverter() {
        return new IConverter<Collection<IService>, Collection<IPayment>>() {
            public Collection<IPayment> convert(Collection<IService> entries) {
                Collection<IPayment> collection = CollectionUtil.create();
                for(IService service : entries){
                    collection.add(serviceConverter().convert(service));
                    for(IService detailService : service.services()){
                        collection.add(paymentFactory.createDetailPayment(detailService.getName(), detailService.getPrice(), detailService.getDate()));
                    }
                }
                return FilterUtil.filter(collection, paymentFilterFactory.noFree());

            }
        };
    }

    private IConverter<IService, IPayment> serviceConverter() {
        return new IConverter<IService, IPayment>() {
            public IPayment convert(IService entry) {
                if(entry instanceof RepairService){
                    return paymentFactory.createAutoRepairPayment(entry.getName(),entry.getPrice(),entry.getDate());
                }
                return paymentFactory.createAutoPayment(entry.getName(),entry.getPrice(),entry.getDate());
            }
        };
    }
}
