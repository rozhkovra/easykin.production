package ru.rrozhkov.easykin.auto.gui.auto;


import ru.rrozhkov.easykin.auto.gui.auto.style.impl.custom.ServiceStyle;
import ru.rrozhkov.easykin.model.auto.ICar;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.gui.IGUIEditor;
import ru.rrozhkov.lib.gui.Table;
import ru.rrozhkov.lib.gui.TablePanel;

import javax.swing.*;
import java.util.Collection;


public class AutoPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public AutoPanel(IGUIEditor parent, ICar car, Collection<IService> services) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new CarForm(car));
		add(new TablePanel(parent, new Table(services, new ServiceStyle())));
	}	
}