package ru.rrozhkov.easykin.work;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.work.gui.ActivityForm;
import ru.rrozhkov.easykin.work.gui.style.impl.custom.ActivityStyle;
import ru.rrozhkov.easykin.work.impl.ActivityBuilder;
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
        Collection collection = activities();
        return new TablePanel(parent, new Table(collection, new ActivityStyle()));
    }
    public static JPanel createEditor(IGUIEditor parent){
        return new ActivityForm(parent);
    }
    public static JPanel createEditor(IGUIEditor parent, IActivity activity){
        return new ActivityForm(parent,activity);
    }
    public static JPanel createFilter(IGUIEditor parent){
        return new JPanel();
    }

    public static Collection activities(){
        return ActivityBuilder.build();
    }
}
