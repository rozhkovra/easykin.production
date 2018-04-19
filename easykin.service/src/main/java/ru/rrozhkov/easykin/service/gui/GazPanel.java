package ru.rrozhkov.easykin.service.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.service.gui.util.CalcUtil;
import ru.rrozhkov.lib.gui.util.GuiUtil;
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
			String text = String.valueOf(((GazCalc)calc).getPrevMeasure());
			prevMesureField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			prevMesureField.getDocument().addDocumentListener(this);
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			String text = String.valueOf(((GazCalc)calc).getCurrentMeasure());
			currentMesureField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			currentMesureField.getDocument().addDocumentListener(this);
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((GazCalc)calc).getRate());
			rateField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
	}
	
	public JLabel getPrevMesureLabel(){
		if(prevMesureLabel == null)
			prevMesureLabel = (JLabel) GuiUtil.label(PREV_MESURE_LABEL_TEXT);
		return prevMesureLabel;
	}
	
	public JLabel getCurrentMesureLabel(){
		if(currentMesureLabel == null)
			currentMesureLabel = (JLabel)GuiUtil.label(CURRENT_MESURE_LABEL_TEXT);
		return currentMesureLabel;
	}
	
	public JLabel getRateLabel(){
		if(rateLabel == null)
			rateLabel = (JLabel)GuiUtil.label(RATE_LABEL_TEXT);
		return rateLabel;
	}

	@Override
	public void updateBean() {
		GazCalc bean = (GazCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}