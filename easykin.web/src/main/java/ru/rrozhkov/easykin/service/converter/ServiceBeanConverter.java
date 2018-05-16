package ru.rrozhkov.easykin.service.converter;

import ru.rrozhkov.easykin.model.service.calc.CalculationType;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.ServiceBean;
import ru.rrozhkov.easykin.service.calc.impl.util.ServiceCalcUtil;
import ru.rrozhkov.lib.convert.IConverter;

import static ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory.getCalculator;

/**
 * Created by rrozhkov on 14.05.2018.
 */
public class ServiceBeanConverter implements IConverter<ServiceCalc, ServiceBean> {
    public ServiceBean convert(ServiceCalc entry) {
        return new ServiceBean(0
                , entry.getName()
                , entry.getDate()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry, CalculationType.WATER)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HOTWATER)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.ELECTRICITY)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.GAZ)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HEATING)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.ANTENNA)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.INTERCOM)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.HOUSE)).calculate().getResult()
                , getCalculator(ServiceCalcUtil.getCalcByType(entry,CalculationType.REPAIR)).calculate().getResult()
                , getCalculator(entry).calculate().getResult()
                , ServiceCalcUtil.getNoPaidSum(entry)
                , ""
                , "");
    }
}
