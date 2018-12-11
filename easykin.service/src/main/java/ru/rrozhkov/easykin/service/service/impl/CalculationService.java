package ru.rrozhkov.easykin.service.service.impl;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.util.DateUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rrozhkov on 11.12.2018.
 */
public class CalculationService {
    private static final StaticReadingDataProvider readingDataProvider = StaticReadingDataProvider.instance();
    private static final StaticServiceCalcDataProvider serviceCalcDataProvider = StaticServiceCalcDataProvider.instance();

    public static class Holder {
        public static final CalculationService INSTANCE = new CalculationService();
    }

    public static CalculationService instance(){
        return Holder.INSTANCE;
    }

    private CalculationService() {
    }

    public Collection calcs() {
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
