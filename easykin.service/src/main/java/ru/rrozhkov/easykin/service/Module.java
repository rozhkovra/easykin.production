package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Measure;
import ru.rrozhkov.easykin.model.service.calc2.impl.Rate;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.ReadingServiceForm;
import ru.rrozhkov.easykin.service.gui.ServiceCalcForm;
import ru.rrozhkov.easykin.service.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    public static JPanel createPanel(IGUIEditor parent){
        Collection collection = new StaticServiceCalcDataProvider().getData();
        return new TablePanel(parent, new Table(collection, new ServiceCalcStyle()));
    }
    public static JPanel createEditor(IGUIEditor parent, ICalculation calc){
        if(calc!=null)
            return new ServiceCalcForm((ServiceCalc)calc);
        return new JPanel();
    }
    public static JPanel createEditor(IGUIEditor parent, IReading newReading, IReading oldReading, Collection<IRate> rates){
        newReading = new Reading(DateUtil.today(),
                (Collection)Arrays.asList(
                        new Measure(null, MeasureType.COLDWATER,Integer.valueOf(41)),
                        new Measure(null, MeasureType.COLDWATER,Integer.valueOf(14)),
                        new Measure(null, MeasureType.HOTWATER,Integer.valueOf(33)),
                        new Measure(null, MeasureType.HOTWATER,Integer.valueOf(26)),
                        new Measure(null, MeasureType.ELECTRICITY, Integer.valueOf(16380))));
        oldReading = new Reading(DateUtil.today(),
                (Collection)Arrays.asList(
                        new Measure(null, MeasureType.COLDWATER,Integer.valueOf(36)),
                        new Measure(null, MeasureType.COLDWATER,Integer.valueOf(14)),
                        new Measure(null, MeasureType.HOTWATER,Integer.valueOf(29)),
                        new Measure(null, MeasureType.HOTWATER,Integer.valueOf(24)),
                        new Measure(null, MeasureType.ELECTRICITY, Integer.valueOf(16291))));
        rates = (Collection)Arrays.asList(
                new Rate(RateType.ELECTRICITY, MoneyFactory.create(3.68),null,null),
                new Rate(RateType.HOTWATER,MoneyFactory.create(90.07),null,null),
                new Rate(RateType.WATERIN,MoneyFactory.create(15.29),null,null),
                new Rate(RateType.WATEROUT,MoneyFactory.create(18.56),null,null));
        if(newReading!=null)
            return new ReadingServiceForm(newReading,
                    oldReading,
                    rates);
        return new JPanel();
    }
    public static Collection<IPayment> payments(){
        return new ServiceCalcConverter().convert(new StaticServiceCalcDataProvider().getData());
    }
}
