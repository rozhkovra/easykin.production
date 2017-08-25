package ru.rrozhkov.easykin.fin;

import ru.rrozhkov.easykin.fin.payment.impl.filter.PaymentFilterFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.PaymentStatus;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.db.impl.PaymentHandler;
import ru.rrozhkov.easykin.payment.gui.PaymentForm;
import ru.rrozhkov.easykin.payment.style.impl.custom.PaymentStyle;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.filter.util.FilterUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    public static JPanel createPanel(IGUIEditor parent){
        Collection collection = CollectionUtil.create();
        for(String module : ModuleManager.activeModules()) {
            Collection payments = (Collection) ModuleManager.invoke(module, "payments");
            if(payments!=null)
                collection.addAll(payments);
        }
        try {
            collection.addAll(PaymentHandler.select());
        }catch(Exception e){

        }
        return new TablePanel(parent, new Table(FilterUtil.filter(collection, PaymentFilterFactory.status(PaymentStatus.PLAN)), new PaymentStyle()));
    }

    public static JPanel createEditor(IGUIEditor parent, IPayment payment){
        return new PaymentForm(parent,payment);
    }
    public static Collection finance(){
        Collection collection = CollectionUtil.create();
        for(String module : ModuleManager.activeModules()) {
            Collection payments = (Collection) ModuleManager.invoke(module, "payments");
            if(payments!=null)
                collection.addAll(payments);
        }
        try {
            collection.addAll(PaymentHandler.select());
        }catch(Exception e){

        }
        return FilterUtil.filter(collection, PaymentFilterFactory.status(PaymentStatus.PLAN));
    }
}
