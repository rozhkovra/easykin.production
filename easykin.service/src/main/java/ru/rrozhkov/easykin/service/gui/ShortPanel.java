package ru.rrozhkov.easykin.service.gui;


import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

public class ShortPanel extends Panel {

	protected ShortPanel(GUIPanel parent, Calculation calc) {
		super(parent, calc);
		fill();
	}

	public void fill() {
		refresh();
		setLayout(guiFactory.gridLayout(1, 2));
		add(getCalcTypeLabel());
		add(getItogoLabel());
	}

	@Override
	public void updateBean() {

	}
}