package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

import java.util.Collection;

public class ServiceCalcPanel extends Panel {
	private static final long serialVersionUID = 1L;
	private static final PanelFactory panelFactory = PanelFactory.instance();

	public static GUIPanel create(ICalculation serviceCalcBean) {
		GUIPanel panel = new ServiceCalcPanel(serviceCalcBean);
		panel.fill();
		return panel;
	}

	private ServiceCalcPanel(ICalculation serviceCalcBean) {
		super(null, serviceCalcBean);
	}

	public void fill() {
		setLayout(guiFactory.gridLayout(5, 4));
		Collection<ICalculation> calcs = ((ServiceCalc)calc).calcs();
        for(ICalculation bean : calcs){
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