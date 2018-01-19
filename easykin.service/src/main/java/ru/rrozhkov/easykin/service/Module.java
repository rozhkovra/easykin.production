package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.ReadingServiceForm;
import ru.rrozhkov.easykin.service.gui.style.impl.custom.ServiceCalcStyle;
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
        return new TablePanel(parent, new Table(calcs(), new ServiceCalcStyle()));
    }

    public static JPanel createEditor(IGUIEditor parent, ICalculation calc){
        if(calc!=null) {
            return new ReadingServiceForm((ServiceCalc)calc);
        }
        return new JPanel();
    }

    public static Collection<IPayment> payments(){
        return new ServiceCalcConverter().convert(calcs());
    }

    public static Collection calcs() {
        Collection collection = CollectionUtil.create();
        collection.addAll(StaticReadingDataProvider.calcs());
        collection.addAll(new StaticServiceCalcDataProvider().getData());
        return collection;
    }
}
