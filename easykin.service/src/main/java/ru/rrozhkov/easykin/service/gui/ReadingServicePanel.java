package ru.rrozhkov.easykin.service.gui;

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
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.util.GuiUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 11/28/2017.
 */
public class ReadingServicePanel extends Panel {
    protected Panel readingCalcPanel;
    protected GUIPanel readingPanel;
    protected IReading reading;

    public ReadingServicePanel(ServiceCalc serviceCalcBean, IReading reading) {
        super(null, serviceCalcBean);
        this.reading = reading;
        this.readingPanel = new ReadingPanel(this, reading, calc.isPaid());
        // no parent for ReadingCalcPanel else recursion
        this.readingCalcPanel = new ReadingCalcPanel(null, calc);
        fill();
    }

    private void fill() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = (JLabel)GuiUtil.label(((ServiceCalc) calc).getName());
        Font font1 = new Font("SansSerif", Font.PLAIN, 30);
        label.setFont(font1);
        label.setHorizontalAlignment(JTextField.LEFT);
        add(label);
        add(readingPanel);
        add(readingCalcPanel);
    }

    @Override
    public void updateBean() {
        ReadingMeasureAdapter readingMeasureFacade = new ReadingMeasureAdapter(reading);
        for(ICalculation calculation : ((ServiceCalc)calc).calcs()) {
            if (calculation instanceof MeasureCalc) {
                MeasureCalc calc = (MeasureCalc)calculation;
                Collection<MeasureType> types = CollectionUtil.create();
                for(IMeasure measure : calc.getNewMeasures()) {
                    types.add(measure.getType());
                }
                calc.getNewMeasures().clear();
                calc.getNewMeasures().addAll(new ReadingMeasureAdapter(reading).getMeasuresByType(types.toArray(new MeasureType[types.size()])));
            }else if(calculation.getType().isWater()) {
                WaterCalc waterCalc = (WaterCalc)calculation;
                waterCalc.setColdCurrentMesure(readingMeasureFacade.getColdMeasure());
                waterCalc.setColdCurrentMesure2(readingMeasureFacade.getColdMeasure2());
                waterCalc.setHotCurrentMesure(readingMeasureFacade.getHotMeasure());
                waterCalc.setHotCurrentMesure2(readingMeasureFacade.getHotMeasure2());
            } else if (calculation.getType().isHotWater()) {
                HotWaterCalc waterCalc = (HotWaterCalc)calculation;
                waterCalc.setCurrentMeasure(readingMeasureFacade.getHotMeasure());
                waterCalc.setCurrentMeasure2(readingMeasureFacade.getHotMeasure2());
            } else if (calculation.getType().isElectricity()) {
                ElectricityCalc elecCalc = (ElectricityCalc)calculation;
                elecCalc.setCurrentMeasure(readingMeasureFacade.getElectricityMeasure());
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
