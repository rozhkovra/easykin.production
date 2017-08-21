package ru.rrozhkov.easykin.service;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.service.data.impl.stat.StaticServiceCalcDataProvider;
import ru.rrozhkov.easykin.service.gui.ServiceCalcForm;
import ru.rrozhkov.easykin.service.gui.style.impl.custom.ServiceCalcStyle;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 8/14/2017.
 */
public class Module {
    public static JPanel createPanel(IGUIEditor parent){
        Collection collection = new StaticServiceCalcDataProvider().getData();
        return new TablePanel(parent, new Table(collection, new ServiceCalcStyle()));
    }
    public static JPanel createEditor(IGUIEditor parent, ICalculation calc){
        if(calc!=null)
            return new ServiceCalcForm((ServiceCalc)calc);
        return new JPanel();
    }
}
