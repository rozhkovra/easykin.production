package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;

import javax.swing.*;
import java.awt.*;

public abstract class Panel extends GUIPanel{
	private static final CalculatorFactory calculatorFactory = new CalculatorFactory();
	private static final long serialVersionUID = 1L;
	private Component itogoLabel = null;
	protected ICalculator calculator;
	protected ICalculation calc;
	protected final static IGUIFactory guiFactory = GUIFactory.create();
	public Panel(Panel parent, ICalculation calc) {
		super(parent);
		this.calc = calc;
		this.calculator = calculatorFactory.getCalculator(calc);
	}

	@Override
	public void updateUI() {
		super.updateUI();
		if(calculator!=null)
			((JLabel)getItogoLabel()).setText(FormatUtil.formatMoney(calculator.calculate().getResult()));
	}

	public Component getItogoLabel(){
		if(itogoLabel == null){
			itogoLabel  = guiFactory.label("");
			itogoLabel.setFont(itogoLabel.getFont().deriveFont(Font.BOLD, 20));			
		}
		return itogoLabel;
	}

	public Component getCalcTypeLabel(){
		return guiFactory.label(String.valueOf(calc.getType()));
	}
	public ICalculation getCalc(){
		return calc;
	}
}