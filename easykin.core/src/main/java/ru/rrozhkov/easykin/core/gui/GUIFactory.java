package ru.rrozhkov.easykin.core.gui;

import ru.rrozhkov.easykin.core.gui.swing.SwingGuiFactory;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public abstract class GUIFactory {
    public static IGUIFactory create() {
        return SwingGuiFactory.instance();
    }
}
