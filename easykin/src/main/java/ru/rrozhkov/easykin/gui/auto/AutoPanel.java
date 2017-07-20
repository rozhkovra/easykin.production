package ru.rrozhkov.easykin.gui.auto;

import static ru.rrozhkov.easykin.gui.PanelFactory.createCarPanel;
import static ru.rrozhkov.easykin.gui.PanelFactory.createAutoServicePanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ru.rrozhkov.easykin.context.MasterDataContext;
import ru.rrozhkov.easykin.gui.EasyKinWindow;

public class AutoPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	public AutoPanel(EasyKinWindow parent, MasterDataContext context) {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		add(createCarPanel(context));
		add(createAutoServicePanel(parent,context.services()));
	}	
}