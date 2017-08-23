package ru.rrozhkov.easykin.fin;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.easykin.payment.gui.PaymentForm;
import ru.rrozhkov.easykin.payment.style.impl.custom.PaymentStyle;
import ru.rrozhkov.lib.collection.CollectionUtil;
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
        return new TablePanel(parent, new Table(collection, new PaymentStyle()));
    }

    public static JPanel createEditor(IGUIEditor parent, IPayment payment){
        return new PaymentForm(parent,payment);
    }
}
