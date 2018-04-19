package ru.rrozhkov.easykin.service.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.service.gui.util.CalcUtil;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.fin.util.FormatUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.def.DefaultCalc;

public class DefaultPanel extends Panel { 
	private static final long serialVersionUID = 1L;
	private JTextField sumField;
	private JLabel sumLabel;
	
	public DefaultPanel(Panel parent, DefaultCalc calcBean) {
		super(parent, calcBean);
		fill();
	}
	
	private void fill(){
		setLayout(new GridLayout(5,2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getCalcTypeLabel());
		add(GuiUtil.labelEmpty());
		add(getSumLabel()); 
		add(getSumField());
		add(GuiUtil.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getSumField(){
		if(sumField == null){
			String sum = FormatUtil.formatEditMoney(((DefaultCalc)calc).getPrice());
			sumField = (JTextField) GuiUtil.fieldCalc(10, sum, calc.isPaid());
			sumField.getDocument().addDocumentListener(this);
		}
		return sumField;
	}
	public JLabel getSumLabel(){
		if(sumLabel == null)
			sumLabel = (JLabel) GuiUtil.label("Сумма");
		return sumLabel;
	}
	@Override
	public void updateBean() {
		DefaultCalc bean = (DefaultCalc)getCalc();
		bean.setPrice(CalcUtil.moneyNUllOrEmpty(getSumField().getText()));
	}
}