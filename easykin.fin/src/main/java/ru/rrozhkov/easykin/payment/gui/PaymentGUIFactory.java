package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;


import java.awt.Component;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class PaymentGUIFactory implements IModuleGUIFactory<IPayment> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    private static class PaymentGUIFactoryHolder {
        private static final PaymentGUIFactory INSTANCE = new PaymentGUIFactory();
    }

    public static PaymentGUIFactory instance(){
        return PaymentGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new PaymentTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, IPayment payment) {
        return PaymentForm.create(parent, payment);
    }

    public Component createView(IGUIEditor parent, IPayment obj) {
        return guiFactory.panelEmpty();
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
