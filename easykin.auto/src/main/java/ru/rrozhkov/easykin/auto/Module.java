package ru.rrozhkov.easykin.auto;

import ru.rrozhkov.easykin.auto.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.auto.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceEditor;
import ru.rrozhkov.easykin.auto.service.impl.convert.ServiceConverter;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    public static JPanel createPanel(IGUIEditor parent){
        SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
        ICar car = autoProvider.getSingleData();
        Collection services = services();
        return new AutoPanel(parent, car, services);
    }
    public static JPanel createEditor(IGUIEditor parent, IService service){
        return new AutoServiceEditor(parent,service);

    }
    public static JPanel createEditor(IGUIEditor parent){
        return new AutoServiceEditor(parent);
    }
    public static Collection<IPayment> payments(){
        return new ServiceConverter().convert(services());
    }

    public static Collection services() {
        SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
        return autoProvider.getData();
    }
}
