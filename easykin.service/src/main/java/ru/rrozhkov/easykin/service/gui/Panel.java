package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.service.CalculatorFactory;
import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;

public abstract class Panel extends GUIPanel{
	private static final CalculatorFactory calculatorFactory = CalculatorFactory.instance();
	protected final static IGUIFactory guiFactory = GUIFactory.create();
	private static final long serialVersionUID = 1L;
	private Component itogoLabel = null;
	protected ICalculator calculator;
	protected ICalculation calc;

	public Panel(GUIPanel parent, ICalculation calc) {
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
			itogoLabel  = guiFactory.labelEmpty();
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