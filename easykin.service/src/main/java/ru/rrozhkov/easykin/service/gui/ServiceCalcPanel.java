package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

public class ServiceCalcPanel extends Panel {
	private static final long serialVersionUID = 1L;
	private static final PanelFactory panelFactory = new PanelFactory();

	public ServiceCalcPanel(ICalculation serviceCalcBean) {
		super(null, serviceCalcBean);
        fill();
	}

	private void fill() {
		setLayout(guiFactory.gridLayout(5, 4));
        for(ICalculation bean : ((ServiceCalc)calc).calcs()){
        	add(panelFactory.getPanel(this, bean));
        }
		refresh();
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getItogoLabel());
	}

	@Override
	public void updateBean() {
	}
}