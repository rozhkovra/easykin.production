package ru.rrozhkov.easykin.gui.service;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.gui.service.util.CalcUtil;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;

public class GazPanel extends Panel{ 
	public static String PREV_MESURE_LABEL_TEXT = "Предыдущие показания";
	public static String CURRENT_MESURE_LABEL_TEXT = "Текущие показания";
	public static String RATE_LABEL_TEXT = "Тариф";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField rateField = null;
	private JLabel prevMesureLabel = null;
	private JLabel currentMesureLabel = null;
	private JLabel rateLabel = null;
	
	public GazPanel(Panel parent, GazCalc calcBean) {
		super(parent, calcBean);
		fill();
	}

	private void fill() {
		setLayout(new GridLayout(7, 2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getCalcTypeLabel());
		add(GuiUtil.labelEmpty());
		add(getPrevMesureLabel()); 
		add(getPrevMesureField()); 
		add(getCurrentMesureLabel()); 
		add(getCurrentMesureField()); 
		add(getRateLabel()); 
		add(getRateField()); 
		add(GuiUtil.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			prevMesureField = new JTextField(5);
			String text = String.valueOf(((GazCalc)calc).getPrevMesure());
			prevMesureField.setText(text);
			prevMesureField.getDocument().addDocumentListener(this);
			if(calc.isPaid())
				prevMesureField.setEditable(false);			
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			currentMesureField = new JTextField(5);
			String text = String.valueOf(((GazCalc)calc).getCurrentMesure());
			currentMesureField.setText(text);
			currentMesureField.getDocument().addDocumentListener(this);
			if(calc.isPaid())
				currentMesureField.setEditable(false);			
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			rateField = new JTextField(5);
			String text = String.valueOf(((GazCalc)calc).getRate());
			rateField.setText(text);
			rateField.getDocument().addDocumentListener(this);
			if (calc.isPaid())
				rateField.setEditable(false);			
		}
		return rateField;
	}
	
	public JLabel getPrevMesureLabel(){
		if(prevMesureLabel == null)
			prevMesureLabel = new JLabel(PREV_MESURE_LABEL_TEXT); 
		return prevMesureLabel;
	}
	
	public JLabel getCurrentMesureLabel(){
		if(currentMesureLabel == null)
			currentMesureLabel = new JLabel(CURRENT_MESURE_LABEL_TEXT); 
		return currentMesureLabel;
	}
	
	public JLabel getRateLabel(){
		if(rateLabel == null)
			rateLabel = new JLabel(RATE_LABEL_TEXT); 
		return rateLabel;
	}

	@Override
	public void updateBean() {
		GazCalc bean = (GazCalc)getCalc();
		bean.setPrevMesure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMesure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}