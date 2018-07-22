package ru.rrozhkov.easykin.service.gui.reading;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.measure.MeasureCalc;
import ru.rrozhkov.easykin.service.calc2.impl.ReadingMeasureAdapter;
import ru.rrozhkov.easykin.service.gui.GUIPanel;
import ru.rrozhkov.easykin.service.gui.Panel;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.Collection;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingServicePanel extends Panel {
    private ReadingMeasureAdapter readingMeasureFacade;
    protected GUIPanel readingCalcPanel;
    protected GUIPanel readingPanel;

    public static GUIPanel create(ServiceCalc serviceCalcBean, IReading reading) {
        GUIPanel panel = new ReadingServicePanel(serviceCalcBean, reading);
        panel.fill();
        return panel;
    }

    protected ReadingServicePanel(ServiceCalc serviceCalcBean, IReading reading) {
        super(null, serviceCalcBean);
        this.readingPanel = ReadingPanel.create(this, reading, calc.isPaid());
        // no parent for ReadingCalcPanel else recursion
        this.readingCalcPanel = ReadingCalcPanel.create(null, calc);
        this.readingMeasureFacade = ReadingMeasureAdapter.create(reading);

    }

    public void fill() {
        setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = (JLabel) guiFactory.label(((ServiceCalc) calc).getName());
        label.setFont(label.getFont().deriveFont(Font.PLAIN, 30));
        label.setHorizontalAlignment(JTextField.LEFT);
        add(label);
        add(readingPanel);
        add(readingCalcPanel);
    }

    @Override
    public void updateBean() {
        for(ICalculation calculation : ((ServiceCalc)calc).calcs()) {
            if(calculation.getType().isWater()) {
                WaterCalc waterCalc = (WaterCalc)calculation;
                waterCalc.setColdCurrentMeasure(readingMeasureFacade.getColdMeasure());
                waterCalc.setColdCurrentMeasure2(readingMeasureFacade.getColdMeasure2());
                waterCalc.setHotCurrentMeasure(readingMeasureFacade.getHotMeasure());
                waterCalc.setHotCurrentMeasure2(readingMeasureFacade.getHotMeasure2());
            } else if (calculation.getType().isHotWater()) {
                HotWaterCalc waterCalc = (HotWaterCalc)calculation;
                waterCalc.setCurrentMeasure(readingMeasureFacade.getHotMeasure());
                waterCalc.setCurrentMeasure2(readingMeasureFacade.getHotMeasure2());
            } else if (calculation.getType().isElectricity()) {
                ElectricityCalc elecCalc = (ElectricityCalc)calculation;
                elecCalc.setCurrentMeasure(readingMeasureFacade.getElectricityMeasure());
            } else if (calculation instanceof MeasureCalc) {
                MeasureCalc calc = (MeasureCalc)calculation;
                Collection<MeasureType> types = CollectionUtil.create();
                for(IMeasure measure : calc.getNewMeasures()) {
                    types.add(measure.getType());
                }
                calc.getNewMeasures().clear();
                calc.getNewMeasures().addAll(readingMeasureFacade.getMeasuresByType(types.toArray(new MeasureType[types.size()])));
            }
        }
    }

    @Override
    public void updateUI() {
        super.updateUI();
        if(this.readingCalcPanel!=null)
            this.readingCalcPanel.updateUI();
    }
}
