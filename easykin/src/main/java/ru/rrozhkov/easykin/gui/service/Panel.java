package ru.rrozhkov.easykin.gui.service;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculator;
import ru.rrozhkov.easykin.model.service.calc.impl.Calculation;
import ru.rrozhkov.easykin.model.service.calc.impl.CalculatorFactory;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public abstract class Panel extends JPanel implements DocumentListener {

	private static final long serialVersionUID = 1L;
	private JLabel itogoLabel = null;
	private ICalculator calculator;
	protected Calculation calc; 
	protected Panel parent;
	public Panel(Panel parent, Calculation calc) {
		super();
		this.calc = calc;
		this.parent = parent;
		this.calculator = CalculatorFactory.getCalculator(calc);
	}

	public void insertUpdate(DocumentEvent e) {
		refresh();
	}

	public void removeUpdate(DocumentEvent e) {
		refresh();
	}

	public void changedUpdate(DocumentEvent e) {
		refresh();
	}

	public void refresh() {
		updateBean();
		updateUI();
		if(parent!=null)
			parent.refresh();

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
	abstract public void updateBean();
}