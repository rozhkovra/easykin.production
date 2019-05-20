package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;

import java.util.Date;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceFactory {
    private static class Holder {
        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }

    public static ServiceFactory instance(){
        return Holder.INSTANCE;
    }

    private ServiceFactory() {
    }

    public ServiceBean serviceBean(int num, String name, Date date, Money water, Money hotWater,
                                   Money electricity, Money gaz, Money heating, Money antenna,
                                   Money intercom, Money house, Money repair, Money itog, Money noPaid,
                                   String tdStyle, String serviceClass) {
        return new ServiceBean(num, name, date, water, hotWater, electricity, gaz, heating, antenna, intercom
                , house, repair, itog, noPaid, tdStyle, serviceClass);
    }

    public ServiceBean serviceBean(int num, String name, Date date, Money water, Money hotWater,
                                   Money electricity, Money gaz, Money heating, Money antenna,
                                   Money intercom, Money house, Money repair, Money garbage, Money itog, Money noPaid,
                                   String tdStyle, String serviceClass) {
        return new ServiceBean(num, name, date, water, hotWater, electricity, gaz, heating, antenna, intercom
                , house, repair, garbage, itog, noPaid, tdStyle, serviceClass);
    }

    public IConverter<ServiceCalc, ServiceBean> calc2BeanConverter() {
        return new IConverter<ServiceCalc, ServiceBean>() {
            public ServiceBean convert(ServiceCalc entry) {
                return serviceBean(0
                        , entry.getName()
                        , entry.getDate()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.WATER).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.HOTWATER).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.ELECTRICITY).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.GAZ).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.HEATING).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.ANTENNA).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.INTERCOM).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.HOUSE).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.REPAIR).getAmount()
                        , ServiceCalcUtil.getCalcByType(entry, CalculationType.GARBAGE)!=null?ServiceCalcUtil.getCalcByType(entry, CalculationType.GARBAGE).getAmount():Money.valueOf(0)
                        , ServiceCalcUtil.getSum(entry)
                        , ServiceCalcUtil.getNoPaidSum(entry)
                        , ""
                        , "");
            }
        };
    }
}
