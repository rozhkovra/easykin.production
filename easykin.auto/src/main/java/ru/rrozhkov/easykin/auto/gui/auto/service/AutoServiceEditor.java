package ru.rrozhkov.easykin.auto.gui.auto.service;

import ru.rrozhkov.easykin.auto.gui.auto.ServiceGUIFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.GUIFactory;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IGUIFactory;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import javax.swing.*;

public class AutoServiceEditor extends JPanel {
	private IModuleGUIFactory serviceFactory = ServiceGUIFactory.instance();
	private static final IGUIFactory guiFactory = GUIFactory.create();

	public AutoServiceEditor(IGUIEditor parent, IService service) {
		super();
		setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));

		add(serviceFactory.createEditor(parent, service));
		if(!CollectionUtil.isNullOrEmpty(service.services()))
			add(serviceFactory.createTablePanel(parent, service.services()));
	}
}
