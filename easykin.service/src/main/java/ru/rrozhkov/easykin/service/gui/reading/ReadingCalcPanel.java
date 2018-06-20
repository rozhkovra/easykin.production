package ru.rrozhkov.easykin.service.gui.reading;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.service.gui.GUIPanel;
import ru.rrozhkov.easykin.service.gui.Panel;
import ru.rrozhkov.easykin.service.gui.ShortPanelFactory;

import java.awt.Component;


/**
 * Created by rrozhkov on 12/7/2017.
 */
public class ReadingCalcPanel extends Panel {
    private static final ShortPanelFactory shortPanelFactory = ShortPanelFactory.instance();

    public static ReadingCalcPanel create(GUIPanel parent, ICalculation calc) {
        ReadingCalcPanel panel = new ReadingCalcPanel(parent, calc);
        panel.fill();
        return panel;
    }

    private ReadingCalcPanel(GUIPanel parent, ICalculation calc) {
        super(parent, calc);
    }

    public void fill() {
        ServiceCalc serviceCalc = (ServiceCalc) calc;
        setLayout(guiFactory.gridLayout(serviceCalc.calcs().size() + 2, 1));
        for(ICalculation bean : serviceCalc.calcs()){
            add(shortPanelFactory.getPanel(this, bean));
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
