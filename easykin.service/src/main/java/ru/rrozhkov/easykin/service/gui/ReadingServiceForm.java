package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.calc2.impl.convert.CalcReadingConverter;
import ru.rrozhkov.easykin.service.db.impl.calc2.MeasureHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.ReadingHandler;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 4/16/2018.
 */
public class ReadingServiceForm extends Form {
    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private static final MeasureHandler measureHandler = new MeasureHandler();
    private static final ReadingHandler readingHandler = new ReadingHandler();
    private static final IConverter<ServiceCalc,IReading> converter = new CalcReadingConverter();

    private IReading reading;
    protected ServiceCalc calc;
    public ReadingServiceForm(IGUIEditor parent, ServiceCalc serviceCalcBean) {
        super(parent);
        this.calc = serviceCalcBean;
        this.reading = converter.convert(calc);
        fill();
    }

    @Override
    protected void fill() {
        setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
        add(guiFactory.labelEmpty());
        add(new ReadingServicePanel(calc, reading));
        Container buttonPanel = guiFactory.panelEmpty();
        buttonPanel.setLayout(guiFactory.boxLayout(buttonPanel, BoxLayout.X_AXIS));
        if (!calc.isPaid()) {
            buttonPanel.add(getOkButton());
        } else {
            buttonPanel.add(guiFactory.labelEmpty());
        }
        buttonPanel.add(getCancelButton());
        add(buttonPanel);
    }

    @Override
    protected void ok() {
        if(!validateData())
            return;
        try{
            if(reading.getId()==-1) {
                int id = readingHandler.insert(reading);
                for(IMeasure measure : reading.getMeasures()) {
                    IMeasure newMeasure = serviceFactory.createMeasure(-1, id, measure.getType(), measure.getValue());
                    measureHandler.insert(newMeasure);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        parent.refresh();
    }
}
