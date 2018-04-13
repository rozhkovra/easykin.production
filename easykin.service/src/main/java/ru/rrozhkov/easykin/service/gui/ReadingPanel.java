package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Measure;
import ru.rrozhkov.lib.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingPanel extends GUIPanel {
    private boolean isPaid;
    protected IReading reading;
    protected Map<IMeasure,JTextField> fields;

    public ReadingPanel(Panel parent, IReading reading, boolean isPaid) {
        super(parent);
        this.reading = reading;
        this.isPaid = isPaid;
        fill();
    }

    private void fill() {
        fields = new HashMap<IMeasure,JTextField>();
        setLayout(new GridLayout(2, reading.getMeasures().size()));
        for(IMeasure measure : reading.getMeasures()){
            add(GuiUtil.label(String.valueOf(measure.getType())));

        }
        for(IMeasure measure : reading.getMeasures()){
            JTextField field = null;
            if (isPaid()) {
                field = (JTextField) GuiUtil.fieldReadOnly(10, measure.getValue().toString());
            } else {
                field = (JTextField) GuiUtil.fieldEditable(10, measure.getValue().toString());
            }
            Font font1 = new Font("SansSerif", Font.PLAIN, 40);
            field.setFont(font1);
            field.setHorizontalAlignment(JTextField.CENTER);
            field.getDocument().addDocumentListener(this);
            add(field);
            fields.put(measure,field);
        }
    }

    public IReading getReading() {
        return reading;
    }

    public boolean isPaid() {
        return isPaid;
    }

    @Override
    public void updateBean() {
        for(IMeasure measure : reading.getMeasures()){
            JTextField field = fields.get(measure);
            if(!field.getText().isEmpty()) {
                Object value = Double.valueOf(field.getText());
                ((Measure) measure).setValue(value);
            }
        }
    }
}
