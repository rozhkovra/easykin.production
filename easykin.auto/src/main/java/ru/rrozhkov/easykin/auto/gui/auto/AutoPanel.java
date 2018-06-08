package ru.rrozhkov.easykin.auto.gui.auto;


import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import javax.swing.*;
import java.util.Collection;


public class AutoPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private final static IGUIFactory guiFactory = GUIFactory.create();
	private IModuleGUIFactory autoFactory = AutoGUIFactory.instance();
	private IModuleGUIFactory serviceFactory = ServiceGUIFactory.instance();

	public AutoPanel(IGUIEditor parent, ICar car, Collection<IService> services) {
		setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));
		add(autoFactory.createEditor(parent, car));
		add(serviceFactory.createTablePanel(parent, services));
	}	
}