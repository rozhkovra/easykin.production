package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.easykin.service.calc2.impl.convert.CalcReadingConverter;
import ru.rrozhkov.easykin.service.db.impl.calc2.MeasureHandler;
import ru.rrozhkov.easykin.service.db.impl.calc2.ReadingHandler;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;

import javax.swing.*;

/**
 * Created by rrozhkov on 4/16/2018.
 */
public class ReadingServiceForm extends Form {
    private IReading reading;
    protected ServiceCalc calc;
    public ReadingServiceForm(IGUIEditor parent, ServiceCalc serviceCalcBean) {
        super(parent);
        this.calc = serviceCalcBean;
        this.reading = new CalcReadingConverter().convert(calc);
        fill();
    }

    @Override
    protected void fill() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(GuiUtil.labelEmpty());
        add(new ReadingServicePanel(calc, reading));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        if (!calc.isPaid()) {
            buttonPanel.add(getOkButton());
        } else {
            buttonPanel.add(GuiUtil.labelEmpty());
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
                int id = ReadingHandler.insert(reading);
                for(IMeasure measure : reading.getMeasures()) {
                    IMeasure newMeasure = ServiceFactory.createMeasure(-1, id, measure.getType(), measure.getValue());
                    MeasureHandler.insert(newMeasure);
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        parent.refresh();
    }
}
