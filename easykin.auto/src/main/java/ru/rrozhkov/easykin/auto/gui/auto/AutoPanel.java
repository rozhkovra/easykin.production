package ru.rrozhkov.easykin.auto.gui.auto;


import ru.rrozhkov.easykin.auto.gui.auto.service.ServiceGUIFactory;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.util.Collection;


public class AutoPanel extends JPanel {
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