package ru.rrozhkov.easykin.payment.gui;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class PaymentGUIFactory implements IGUIFactory{
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new TablePanel(parent, new Table(new PaymentTableModel(data)));
    }

    public JPanel createEditor(IGUIEditor parent, Object obj) {
        return new PaymentForm(parent,(IPayment)obj);
    }

    public JPanel createFilter(IGUIEditor parent) {
        return new JPanel();
    }
}
