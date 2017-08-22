package ru.rrozhkov.easykin.gui;


import ru.rrozhkov.easykin.module.ModuleManager;
import ru.rrozhkov.lib.gui.IGUIEditor;

import javax.swing.*;

public class FormFactory {
	public static JPanel getFormPanel(String module, IGUIEditor parent, Object obj) {
		if(ModuleManager.exist(module)) {
			if(obj!=null)
				return (JPanel)ModuleManager.invoke(module, "createEditor", parent, obj);
			else
				return (JPanel)ModuleManager.invoke(module, "createEditor", parent);
		}
		return new JPanel();
	}
}
