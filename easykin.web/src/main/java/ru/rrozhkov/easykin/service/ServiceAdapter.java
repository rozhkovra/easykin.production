package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;
import ru.rrozhkov.easykin.service.service.impl.CalculationService;

import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceAdapter {
    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private static final CalculationService calculationService = CalculationService.instance();
    private static final IConverter<ServiceCalc, ServiceBean> converter = serviceFactory.calc2BeanConverter();

    public Collection<ServiceBean> services() {
        Collection<ServiceBean> beans = CollectionUtil.create();
        Collection<ServiceCalc> calcs = calcs();
        for (ServiceCalc calc : calcs) {
            ServiceBean bean = converter.convert(calc);
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

    public Collection<ServiceBean> services(int year) {
        Collection<ServiceBean> beans = CollectionUtil.create();
        Collection<ServiceCalc> calcs = calcs();
        for (ServiceCalc calc : calcs) {
            ServiceBean bean = converter.convert(calc);
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

    private static Collection calcs(){
        return calculationService.calcs();
    }
}
