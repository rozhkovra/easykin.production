package ru.rrozhkov.easykin.gui;

import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

public class PanelFactory {
	public static JPanel createPanel(String module, IGUIEditor parent) {
		if (ModuleManager.exist(module)) {
			JPanel panel = (JPanel) ModuleManager.invoke(module, "createPanel", parent);
			if (panel == null)
				panel = new JPanel();
			return panel;
		}
		return new JPanel();
	}
}
