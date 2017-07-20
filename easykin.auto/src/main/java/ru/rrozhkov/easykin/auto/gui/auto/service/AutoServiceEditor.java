package ru.rrozhkov.easykin.auto.gui.auto.service;

import javax.swing.*;

import ru.rrozhkov.easykin.auto.gui.auto.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.collection.CollectionUtil;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

public class AutoServiceEditor extends JPanel {

	public AutoServiceEditor(IGUIEditor parent, IService service) {
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		if(service!=null && service instanceof IService)
			add(new AutoServiceForm(parent,service));
		else
			add(new AutoServiceForm(parent));
		if(!CollectionUtil.isNullOrEmpty(service.services()))
			add(new TablePanel(parent, new Table(service.services(), new ServiceStyle())));
	}
	public AutoServiceEditor(IGUIEditor parent) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(new AutoServiceForm(parent,null));
	}
}
