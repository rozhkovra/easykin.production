package ru.rrozhkov.easykin.auto.gui.auto;

import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import java.awt.*;
import java.util.Collection;

/**
 * Created by rrozhkov on 21.05.2018.
 */
public class AutoGUIFactory implements IModuleGUIFactory<ICar> {
    private final static IGUIFactory guiFactory = GUIFactory.create();

    public static class Holder {
        public static final AutoGUIFactory INSTANCE = new AutoGUIFactory();
    }

    public static AutoGUIFactory instance(){
        return Holder.INSTANCE;
    }

    public Component createTablePanel(IGUIEditor parent, Collection data) {
        return guiFactory.panelEmpty();
    }

    public Component createEditor(IGUIEditor parent, ICar car) {
        return new CarForm(car);
    }

    public Component createFilter(IGUIEditor parent) {
        return guiFactory.panelEmpty();
    }
}
