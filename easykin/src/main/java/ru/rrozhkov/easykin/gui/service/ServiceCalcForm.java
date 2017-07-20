package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ServiceCalc;

import java.awt.*;

public class ServiceCalcForm extends Panel {
	private static final long serialVersionUID = 1L;
	
	public ServiceCalcForm(ServiceCalc serviceCalcBean) {
		super(null, serviceCalcBean);
        fill();
	}

	private void fill() {
		setLayout(new GridLayout(5, 4));
        for(ICalculation bean : ((ServiceCalc)calc).calcs()){
        	add(PanelFactory.getPanel(this, bean));
        }
		refresh();
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getItogoLabel());
	}

	@Override
	public void updateBean() {
	}
}