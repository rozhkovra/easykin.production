package ru.rrozhkov.lib.gui;

import ru.rrozhkov.lib.gui.swing.SwingGuiFactory;

/**
 * Created by rrozhkov on 31.05.2018.
 */
public abstract class GUIFactory {
    public static IGUIFactory create() {
        return SwingGuiFactory.instance();
    }
}
