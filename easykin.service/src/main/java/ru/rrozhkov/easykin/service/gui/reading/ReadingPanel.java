package ru.rrozhkov.easykin.service.gui.reading;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.Measure;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.service.gui.GUIPanel;
import ru.rrozhkov.easykin.service.gui.Panel;

import javax.swing.JTextField;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingPanel extends GUIPanel {
    private boolean isPaid;
    protected IReading reading;
    protected Map<IMeasure,JTextField> fields;
    protected static final IGUIFactory guiFactory = GUIFactory.create();

    public static GUIPanel create(Panel parent, IReading reading, boolean isPaid) {
        GUIPanel panel = new ReadingPanel(parent, reading, isPaid);
        panel.fill();
        return panel;
    }

    private ReadingPanel(Panel parent, IReading reading, boolean isPaid) {
        super(parent);
        this.reading = reading;
        this.isPaid = isPaid;
    }

    public void fill() {
        fields = new HashMap<IMeasure,JTextField>();
        setLayout(guiFactory.gridLayout(2, reading.getMeasures().size()));
        for(IMeasure measure : reading.getMeasures()){
            add(guiFactory.label(String.valueOf(measure.getType())));

        }
        for(IMeasure measure : reading.getMeasures()){
            JTextField field = (JTextField) guiFactory.fieldCalc(10, measure.getValue().toString(), isPaid());
            field.setFont(field.getFont().deriveFont(Font.PLAIN, 40));
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
