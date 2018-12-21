package ru.rrozhkov.easykin.payment.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.filter.IFilter;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.core.service.impl.EntityService;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 12.12.2018.
 */
public class PaymentService extends EntityService {
    private static final ModuleManager moduleManager = ModuleManager.instance();
    private static final PaymentFilterFactory paymentFilterFactory = PaymentFilterFactory.instance();
    private static final PaymentHandler paymentHandler = PaymentHandler.instance();

    private PaymentService() {
        super(paymentHandler);
    }

    private static class Holder {
        private static final PaymentService INSTANCE = new PaymentService();
    }

    public static PaymentService instance(){
        return Holder.INSTANCE;
    }

    public Collection<IPayment> paymentsPlan() {
        Collection<IPayment> collection = payments(paymentFilterFactory.status(PaymentStatus.PLAN));
        Collections.sort((List) collection, new Comparator<IPayment>() {
            public int compare(IPayment o1, IPayment o2) {
                return DateUtil.formatSql(o1.getDate()).compareTo(DateUtil.formatSql(o2.getDate()));
            }
        });
        return collection;
    }

    public Collection<IPayment> paymentsFact() {
        Collection<IPayment> collection = payments(paymentFilterFactory.status(PaymentStatus.FACT));
        Collections.sort((List) collection, new Comparator<IPayment>() {
            public int compare(IPayment o1, IPayment o2) {
                return DateUtil.formatSql(o2.getDate()).compareTo(DateUtil.formatSql(o1.getDate()));
            }
        });
        return collection;
    }

    public IPayment payment(int id) {
        try {
            return paymentHandler.selectForId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Collection<IPayment> payments(IFilter filter) {
        return FilterUtil.filter(payments(), filter);
    }

    private Collection<IPayment> payments() {
        Collection<IPayment> collection = CollectionUtil.create();
        for(String module : moduleManager.activeModules()) {
            Collection payments = (Collection) moduleManager.invoke(module, "payments");
            if(payments!=null) {
                collection.addAll(payments);
            }
        }
        return collection;
    }
}
