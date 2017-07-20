package ru.rrozhkov.easykin.gui.auto.service;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.gui.EasyKinWindow;
import ru.rrozhkov.easykin.gui.FormFactory;
import ru.rrozhkov.easykin.gui.PanelFactory;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.collection.CollectionUtil;

public class AutoServiceEditor extends JPanel {

	public AutoServiceEditor(EasyKinWindow parent, IService service) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createAutoServiceForm(parent, service));
		if(!CollectionUtil.isNullOrEmpty(service.services()))
			add(PanelFactory.createAutoServicePanel(parent,service.services()));
	}
	public AutoServiceEditor(EasyKinWindow parent) {
		super();
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(FormFactory.createAutoServiceForm(parent, null));
	}
}
