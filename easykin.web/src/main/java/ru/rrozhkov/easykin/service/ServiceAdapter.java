package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.converter.ServiceBeanConverter;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceAdapter {
    public static Collection<ServiceBean> services() {
        Collection<ServiceBean> beans = CollectionUtil.create();
        Collection<ServiceCalc> calcs = Module.calcs();
        for (ServiceCalc calc : calcs) {
            ServiceBean bean = new ServiceBeanConverter().convert(calc);
            if (calc.isPaid()) {
                bean.setServiceClass("label bg-green");
                bean.setTdStyle("font-weight:bold;");
            } else {
                bean.setServiceClass("label bg-yellow");
            }
            beans.add(bean);
        }
        return beans;
    }
    public static Collection<ServiceBean> services(int year) {
        Collection<ServiceBean> beans = CollectionUtil.create();
        Collection<ServiceCalc> calcs = Module.calcs();
        for (ServiceCalc calc : calcs) {
            ServiceBean bean = new ServiceBeanConverter().convert(calc);
            if (calc.isPaid()) {
                bean.setServiceClass("label bg-green");
                bean.setTdStyle("font-weight:bold;");
            } else {
                bean.setServiceClass("label bg-yellow");
            }
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(calc.getDate());
            int calcYear = calendar.get(Calendar.YEAR);
            if(calcYear == year) {
                beans.add(bean);
            }
        }
        return beans;
    }
}