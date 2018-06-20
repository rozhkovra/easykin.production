package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.convert.ServiceConverterFactory;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.Calc2GUIFactory;


import java.awt.Component;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    private static IModuleGUIFactory calc2Factory = Calc2GUIFactory.instance();
    private static final ServiceConverterFactory converterFactory = ServiceConverterFactory.instance();
    private static final IConverter<Collection<ServiceCalc>, Collection<IPayment>> converter = converterFactory.serviceCalcConverter();
    private static final StaticReadingDataProvider readingDataProvider = StaticReadingDataProvider.instance();
    private static final StaticServiceCalcDataProvider serviceCalcDataProvider = StaticServiceCalcDataProvider.instance();


    public static Component createPanel(IGUIEditor parent){
        return calc2Factory.createTablePanel(parent, calcs());
    }

    public static Component createEditor(IGUIEditor parent, ICalculation calc){
        return calc2Factory.createEditor(parent, calc);
    }

    public static Component createEditor(IGUIEditor parent){
        return calc2Factory.createEditor(parent, null);
    }

    public static Collection payments(){
        return converter.convert(calcs());
    }

    public static Collection calcs() {
        Collection collection = CollectionUtil.create();
        collection.addAll(readingDataProvider.calcs());
        collection.addAll(serviceCalcDataProvider.getData());
        Collections.sort((List) collection, new Comparator<ServiceCalc>() {
            public int compare(ServiceCalc o1, ServiceCalc o2) {
                return DateUtil.formatSql(o2.getDate()).compareTo(DateUtil.formatSql(o1.getDate()));
            }
        });
        return collection;
    }
}
