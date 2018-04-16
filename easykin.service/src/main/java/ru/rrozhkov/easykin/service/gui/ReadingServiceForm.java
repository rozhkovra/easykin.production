package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.lib.gui.Form;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.util.GuiUtil;

import javax.swing.*;

/**
 * Created by rrozhkov on 4/16/2018.
 */
public class ReadingServiceForm extends Form {
    protected ServiceCalc calc;
    public ReadingServiceForm(IGUIEditor parent, ServiceCalc serviceCalcBean) {
        super(parent);
        this.calc = serviceCalcBean;
        fill();
    }

    @Override
    protected void fill() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(GuiUtil.labelEmpty());
        add(new ReadingServicePanel(calc));
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
}
