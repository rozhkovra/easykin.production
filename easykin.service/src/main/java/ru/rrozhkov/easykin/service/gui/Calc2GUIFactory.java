package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Reading;
import ru.rrozhkov.easykin.service.calc2.impl.Calc2Factory;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingBuilder;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticReadingDataProvider;
import ru.rrozhkov.easykin.service.db.impl.calc2.RateHandler;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;
import ru.rrozhkov.lib.util.DateUtil;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class Calc2GUIFactory implements IGUIFactory{
    public JPanel createTablePanel(IGUIEditor parent, Collection data) {
        return new TablePanel(parent, new Table(new ServiceTableModel(data)));
    }

    public JPanel createEditor(IGUIEditor parent, Object calc) {
        if(calc==null) {
            Collection<IRate> rates;
            try {
                rates = RateHandler.selectForDate(DateUtil.lastDayOfMonth(DateUtil.today()));
            } catch (Exception e) {
                rates = StaticReadingDataProvider.rates2018_1;
            }
            List<IReading> readings = (List) ReadingBuilder.build();
            IReading oldReading = readings.get(readings.size()-1);
            IReading newReading = null;
            try {
                newReading = ((Reading)oldReading).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            calc = Calc2Factory.createEmptyServiceCalc(oldReading, newReading, rates);
        }
        return new ReadingServiceForm(parent, (ServiceCalc)calc);

    }

    public JPanel createFilter(IGUIEditor parent) {
        return null;
    }
}
