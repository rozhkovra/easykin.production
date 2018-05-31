package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.Calc2GUIFactory;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory calc2Factory = new Calc2GUIFactory();
    public static JPanel createPanel(IGUIEditor parent){
        return calc2Factory.createTablePanel(parent, calcs());
    }

    public static JPanel createEditor(IGUIEditor parent, ICalculation calc){
        return calc2Factory.createEditor(parent, calc);
    }

    public static JPanel createEditor(IGUIEditor parent){
        return calc2Factory.createEditor(parent, null);
    }

    public static Collection<IPayment> payments(){
        return new ServiceCalcConverter().convert(calcs());
    }

    public static Collection calcs() {
        Collection collection = CollectionUtil.create();
        collection.addAll(StaticReadingDataProvider.calcs());
        collection.addAll(new StaticServiceCalcDataProvider().getData());
        Collections.sort((List) collection, new Comparator<ServiceCalc>() {
            public int compare(ServiceCalc o1, ServiceCalc o2) {
                return DateUtil.formatSql(o2.getDate()).compareTo(DateUtil.formatSql(o1.getDate()));
            }
        });
        return collection;
    }
}
