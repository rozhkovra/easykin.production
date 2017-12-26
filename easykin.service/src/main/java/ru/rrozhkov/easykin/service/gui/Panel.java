package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;

import javax.swing.*;
import java.awt.*;

public abstract class Panel extends GUIPanel{

	private static final long serialVersionUID = 1L;
	private JLabel itogoLabel = null;
	protected ICalculator calculator;
	protected Calculation calc;
	public Panel(Panel parent, Calculation calc) {
		super(parent);
		this.calc = calc;
		this.calculator = CalculatorFactory.getCalculator(calc);
	}

	@Override
	public void updateUI() {
		super.updateUI();
		if(calculator!=null)
			getItogoLabel().setText(FormatUtil.formatMoney(calculator.calculate().getResult()));
	}

	public JLabel getItogoLabel(){
		if(itogoLabel == null){
			itogoLabel  = new JLabel("");
			itogoLabel.setFont(itogoLabel.getFont().deriveFont(Font.BOLD, 20));			
		}
		return itogoLabel;
	}

	public JLabel getCalcTypeLabel(){
		return new JLabel(String.valueOf(calc.getType()));
	}
	public Calculation getCalc(){
		return calc;
	}
}