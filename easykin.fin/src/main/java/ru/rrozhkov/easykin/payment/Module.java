package ru.rrozhkov.easykin.payment;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.fin.payment.impl.PaymentFactory;
import ru.rrozhkov.easykin.payment.gui.PaymentGUIFactory;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;

import java.awt.Component;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final IModuleGUIFactory paymentGuiFactory = PaymentGUIFactory.instance();
    private static final PaymentService paymentService = PaymentService.instance();
    private static final PaymentFactory paymentFactory = PaymentFactory.instance();

    public static Component createPanel(IGUIEditor parent){
        return paymentGuiFactory.createTablePanel(parent, paymentService.paymentsFact());
    }

    public static Component createEditor(IGUIEditor parent, IPayment payment){
        return paymentGuiFactory.createEditor(parent, payment);
    }

    public static Component createEditor(IGUIEditor parent){
        IPayment payment = paymentFactory.newPayment();
        return paymentGuiFactory.createEditor(parent,payment);
    }
}
