package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

import java.awt.*;

/**
 * Created by rrozhkov on 12/7/2017.
 */
public class ReadingCalcPanel extends Panel {
    public ReadingCalcPanel(Panel parent, Calculation calc) {
        super(parent, calc);
        fill();
    }

    private void fill() {
        setLayout(new GridLayout(((ServiceCalc)calc).calcs().size()+2, 1));
        for(ICalculation bean : ((ServiceCalc)calc).calcs()){
            add(ShortPanelFactory.getPanel(this, bean));
        }
        refresh();
        add(guiFactory.labelEmpty());
        add(getItogoLabel());
    }

    @Override
    public void updateBean() {

    }

    @Override
    public void updateUI() {
        super.updateUI();
        for(Component component : getComponents()) {
            if(component instanceof Panel) {
                Panel panel = (Panel)component;
                panel.updateUI();
            }
        }
    }
}
