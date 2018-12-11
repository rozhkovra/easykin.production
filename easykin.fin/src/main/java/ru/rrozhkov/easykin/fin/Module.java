package ru.rrozhkov.easykin.fin;

import ru.rrozhkov.easykin.fin.gui.FinanceGUIFactory;
import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.awt.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final ModuleManager moduleManager = ModuleManager.instance();
    private static IModuleGUIFactory financeFactory = FinanceGUIFactory.instance();
    private static final PaymentHandler paymentHandler = PaymentHandler.instance();
    private static final PaymentFilterFactory paymentFilterFactory = PaymentFilterFactory.instance();

    public static Component createPanel(IGUIEditor parent){
        return financeFactory.createTablePanel(parent, finance());
    }

    public static Component createEditor(IGUIEditor parent, IPayment payment){
        return financeFactory.createEditor(parent,payment);
    }
    public static Collection finance(){
        Collection collection = CollectionUtil.create();
        for(String module : moduleManager.activeModules()) {
            Collection payments = (Collection) moduleManager.invoke(module, "payments");
            if(payments!=null) {
                collection.addAll(payments);
            }
        }

        Collections.sort((List) collection, new Comparator<IPayment>() {
            public int compare(IPayment o1, IPayment o2) {
                return DateUtil.formatSql(o1.getDate()).compareTo(DateUtil.formatSql(o2.getDate()));
            }
        });
        return FilterUtil.filter(collection, paymentFilterFactory.status(PaymentStatus.PLAN));
    }
}
