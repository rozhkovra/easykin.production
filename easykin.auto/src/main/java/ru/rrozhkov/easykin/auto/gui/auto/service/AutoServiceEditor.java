package ru.rrozhkov.easykin.auto.gui.auto.service;

import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.core.gui.IModuleGUIFactory;

import javax.swing.*;

public class AutoServiceEditor extends JPanel {
	private IModuleGUIFactory serviceFactory = ServiceGUIFactory.instance();
	private static final IGUIFactory guiFactory = GUIFactory.create();

	protected AutoServiceEditor(IGUIEditor parent, IService service) {
		super();
		setLayout(guiFactory.boxLayout(this, BoxLayout.Y_AXIS));

		add(serviceFactory.createView(parent, service));
		if(!CollectionUtil.isNullOrEmpty(service.services()))
			add(serviceFactory.createTablePanel(parent, service.services()));
	}
}
