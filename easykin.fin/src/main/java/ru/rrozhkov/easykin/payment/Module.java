package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.payment.gui.PaymentGUIFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;
import ru.rrozhkov.lib.util.DateUtil;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final ModuleManager moduleManager = new ModuleManager();
    private static IModuleGUIFactory paymentFactory = new PaymentGUIFactory();
    private static final PaymentHandler paymentHandler = new PaymentHandler();
    private static final PaymentFilterFactory paymentFilterFactory = new PaymentFilterFactory();

    public static Component createPanel(IGUIEditor parent){
        return paymentFactory.createTablePanel(parent, finance());
    }

    public static Component createEditor(IGUIEditor parent, IPayment payment){
        return paymentFactory.createEditor(parent,payment);
    }
    public static Collection finance(){
        Collection<IPayment> collection = CollectionUtil.create();
        for(String module : moduleManager.activeModules()) {
            Collection payments = (Collection) moduleManager.invoke(module, "payments");
            if(payments!=null) {
                collection.addAll(payments);
            }
        }
        try {
            collection.addAll(paymentHandler.select());
        }catch(Exception e){

        }
        Collections.sort((List)collection,new Comparator<IPayment>() {
            public int compare(IPayment o1, IPayment o2) {
                return DateUtil.formatSql(o2.getDate()).compareTo(DateUtil.formatSql(o1.getDate()));
            }
        });
        return FilterUtil.filter(collection, paymentFilterFactory.status(PaymentStatus.FACT));
    }
}
