package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.payment.IPayment;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.Rate;
import ru.rrozhkov.easykin.service.calc.impl.convert.ServiceCalcConverter;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.ReadingServiceForm;
import ru.rrozhkov.easykin.service.gui.ServiceCalcForm;
import ru.rrozhkov.easykin.service.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

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

        if(calc!=null) {
            return new ServiceCalcForm((ServiceCalc)calc);
        }
        return new JPanel();
    }

    public static JPanel createEditor(IGUIEditor parent, IReading reading){
        Collection<IRate> rates = (Collection)Arrays.asList(
                new Rate(RateType.REPAIR, Money.valueOf(341.03),null,null),
                new Rate(RateType.HEATING, Money.valueOf(1589.04),null,null),
                new Rate(RateType.INTERCOM, Money.valueOf(30.00),null,null),
                new Rate(RateType.ANTENNA, Money.valueOf(72.00),null,null),
                new Rate(RateType.ELECTRICITY, Money.valueOf(3.68),null,null),
                new Rate(RateType.HOTWATER,Money.valueOf(90.07),null,null),
                new Rate(RateType.WATERIN,Money.valueOf(15.29),null,null),
                new Rate(RateType.WATEROUT,Money.valueOf(18.56),null,null));
        if(reading!=null) {
            return new ReadingServiceForm(reading,
                    null,
                    rates);
        }
        return new JPanel();
    }

    public static Collection<IPayment> payments(){
        return new ServiceCalcConverter().convert(new StaticServiceCalcDataProvider().getData());
    }
}
