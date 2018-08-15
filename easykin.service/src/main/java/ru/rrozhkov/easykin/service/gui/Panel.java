package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.core.gui.GUIFactory;
import ru.rrozhkov.easykin.core.gui.IGUIFactory;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;

import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;

public abstract class Panel extends GUIPanel{
	protected final static IGUIFactory guiFactory = GUIFactory.create();
	private static final long serialVersionUID = 1L;
	private Component itogoLabel = null;
	protected ICalculation calc;

	public Panel(GUIPanel parent, ICalculation calc) {
		super(parent);
		this.calc = calc;
	}

	@Override
	public void updateUI() {
		super.updateUI();
		if (calc != null) {
			((JLabel) getItogoLabel()).setText(FormatUtil.formatMoney(calc.getAmount()));
		}
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