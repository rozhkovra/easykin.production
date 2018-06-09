package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.easykin.core.convert.IConverter;

import java.util.Date;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceFactory {
    private static final CalculatorFactory calculatorFactory = new CalculatorFactory();

    public ServiceBean serviceBean(int num, String name, Date date, Money water, Money hotWater,
                                   Money electricity, Money gaz, Money heating, Money antenna,
                                   Money intercom, Money house, Money repair, Money itog, Money noPaid,
                                   String tdStyle, String serviceClass) {
        return new ServiceBean(num, name, date, water, hotWater, electricity, gaz, heating, antenna, intercom
                , house, repair, itog, noPaid, tdStyle, serviceClass);
    }

    public IConverter<ServiceCalc, ServiceBean> calc2BeanConverter() {
        return new IConverter<ServiceCalc, ServiceBean>() {
            public ServiceBean convert(ServiceCalc entry) {
                return serviceBean(0
                        , entry.getName()
                        , entry.getDate()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.WATER)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.HOTWATER)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.ELECTRICITY)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.GAZ)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.HEATING)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.ANTENNA)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.INTERCOM)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.HOUSE)).calculate().getResult()
                        , calculatorFactory.getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.REPAIR)).calculate().getResult()
                        , calculatorFactory.getCalculator(entry).calculate().getResult()
                        , ServiceCalcUtil.getNoPaidSum(entry)
                        , ""
                        , "");
            }
        };
    }
}
