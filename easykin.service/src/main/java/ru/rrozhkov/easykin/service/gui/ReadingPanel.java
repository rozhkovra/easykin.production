package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingPanel extends JPanel {
    protected IReading<IMeasure> reading;

    public ReadingPanel(IReading reading) {
        this.reading = reading;
        fill();
    }

    private void fill() {
        setLayout(new GridLayout(1, reading.getMeasures().size()*2));
        for(IMeasure measure : reading.getMeasures()){
            add(new Label(String.valueOf(measure.getType())));
            add(new TextField(measure.getValue().toString()));
        }
    }

    public IReading getReading() {
        return reading;
    }
}
