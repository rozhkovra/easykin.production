package ru.rrozhkov.easykin.auto;

import ru.rrozhkov.easykin.auto.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.auto.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceEditor;
import ru.rrozhkov.easykin.auto.service.impl.convert.ServiceConverter;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.lib.gui.IGUIEditor;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    final private static SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
    public static Component createPanel(IGUIEditor parent){
        return new AutoPanel(parent, car(), services());
    }
    public static Component createEditor(IGUIEditor parent, IService service){
        return new AutoServiceEditor(parent,service);
    }
    public static Component createEditor(IGUIEditor parent){
        return new AutoServiceEditor(parent);
    }
    public static Collection payments(){
        return new ServiceConverter().convert(services());
    }

    public static Collection services() {
        return autoProvider.getData();
    }
    public static ICar car() {
        return autoProvider.getSingleData();
    }
}
