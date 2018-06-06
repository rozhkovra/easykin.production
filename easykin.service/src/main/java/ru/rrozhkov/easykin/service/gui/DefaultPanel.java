package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.*;

public class DefaultPanel extends Panel { 
	private static final long serialVersionUID = 1L;
	private JTextField sumField;
	private JLabel sumLabel;
	
	public DefaultPanel(Panel parent, ICalculation calcBean) {
		super(parent, calcBean);
		fill();
	}
	
	private void fill(){
		setLayout(guiFactory.gridLayout(5,2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getSumLabel()); 
		add(getSumField());
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getSumField(){
		if(sumField == null){
			String sum = FormatUtil.formatEditMoney(((DefaultCalc)calc).getPrice());
			sumField = (JTextField) guiFactory.fieldCalc(10, sum, calc.isPaid());
			sumField.getDocument().addDocumentListener(this);
		}
		return sumField;
	}
	public JLabel getSumLabel(){
		if(sumLabel == null)
			sumLabel = (JLabel) guiFactory.label("Сумма");
		return sumLabel;
	}
	@Override
	public void updateBean() {
		DefaultCalc bean = (DefaultCalc)getCalc();
		bean.setPrice(CalcUtil.moneyNUllOrEmpty(getSumField().getText()));
	}
}