package ru.rrozhkov.easykin.auto;

import ru.rrozhkov.easykin.auto.data.impl.stat.StaticServiceHistoryDataProvider;
import ru.rrozhkov.easykin.auto.gui.auto.AutoPanel;
import ru.rrozhkov.easykin.auto.gui.auto.service.AutoServiceEditor;
import ru.rrozhkov.easykin.auto.service.impl.convert.ServiceConverter;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.data.impl.SingleCollectionDataProvider;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static final SingleCollectionDataProvider<IService, ICar> autoProvider = new StaticServiceHistoryDataProvider();
    private static final IConverter<Collection<IService>,Collection<IPayment>> converter = new ServiceConverter();

    public static Component createPanel(IGUIEditor parent){
        return new AutoPanel(parent, car(), services());
    }
    public static Component createEditor(IGUIEditor parent, IService service){
        return new AutoServiceEditor(parent,service);
    }
    public static Component createEditor(IGUIEditor parent){
        return new AutoServiceEditor(parent,null);
    }
    public static Collection payments(){
        return converter.convert(services());
    }

    public static Collection services() {
        return autoProvider.getData();
    }
    public static ICar car() {
        return autoProvider.getSingleData();
    }
}
