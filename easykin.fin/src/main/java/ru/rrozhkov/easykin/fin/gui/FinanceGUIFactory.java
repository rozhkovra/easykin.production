package ru.rrozhkov.easykin.fin.gui;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.payment.gui.PaymentForm;
import ru.rrozhkov.easykin.payment.gui.PaymentTableModel;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class FinanceGUIFactory implements IModuleGUIFactory<IPayment> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class FinanceGUIFactoryHolder {
        public static final FinanceGUIFactory INSTANCE = new FinanceGUIFactory();
    }

    public static FinanceGUIFactory instance(){
        return FinanceGUIFactoryHolder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.tablePanel(parent, new PaymentTableModel(data));
    }

    public Component createEditor(IGUIEditor parent, IPayment payment) {
        return new PaymentForm(parent, payment);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
