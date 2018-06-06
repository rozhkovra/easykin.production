package ru.rrozhkov.easykin.service.gui;


import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;

import java.awt.*;

public class ShortPanel extends Panel{

	public ShortPanel(Panel parent, Calculation calc) {
		super(parent, calc);
		fill();
	}

	private void fill() {
		refresh();
		setLayout(guiFactory.gridLayout(1, 2));
		add(getCalcTypeLabel());
		add(getItogoLabel());
	}

	@Override
	public void updateBean() {

	}
}