package ru.rrozhkov.easykin.auto.gui.auto.service;

import ru.rrozhkov.easykin.auto.gui.auto.ServiceGUIFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.IModuleGUIFactory;

import javax.swing.*;

public class AutoServiceEditor extends JPanel {
	private IModuleGUIFactory serviceFactory = new ServiceGUIFactory();
	public AutoServiceEditor(IGUIEditor parent, IService service) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		if(service!=null && service instanceof IService)
			add(serviceFactory.createEditor(parent, service));
		else
			add(serviceFactory.createEditor(parent, null));
		if(!CollectionUtil.isNullOrEmpty(service.services()))
			add(serviceFactory.createTablePanel(parent, service.services()));
	}
	public AutoServiceEditor(IGUIEditor parent) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(serviceFactory.createEditor(parent, null));
	}
}
