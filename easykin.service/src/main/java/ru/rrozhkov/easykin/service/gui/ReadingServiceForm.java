package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.service.calc2.impl.ServiceCalcBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingServiceForm extends JPanel {
    protected IReading newReading;
    protected IReading oldReading;
    protected Collection<IRate> rates;

    public ReadingServiceForm(IReading newReading, IReading oldReading, Collection<IRate> rates) {
        this.newReading = newReading;
        this.oldReading = oldReading;
        this.rates = rates;
        fill();
    }

    private void fill() {
        setLayout(new GridLayout(2, 1));
        add(new ReadingPanel(newReading));
        add(new ReadingCalcPanel((Calculation) new ServiceCalcBuilder(newReading,oldReading,rates).build()));
    }
}
