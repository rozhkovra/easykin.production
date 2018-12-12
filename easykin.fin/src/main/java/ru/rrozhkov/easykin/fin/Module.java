package ru.rrozhkov.easykin.fin;

import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.fin.gui.FinanceGUIFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.service.impl.PaymentService;

import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final PaymentService paymentService = PaymentService.instance();
    private static IModuleGUIFactory financeGuiFactory = FinanceGUIFactory.instance();

    public static Component createPanel(IGUIEditor parent){
        return financeGuiFactory.createTablePanel(parent, finance());
    }

    public static Component createEditor(IGUIEditor parent, IPayment payment){
        return financeGuiFactory.createEditor(parent,payment);
    }

    private static Collection finance(){
        return paymentService.paymentsPlan();
    }
}
