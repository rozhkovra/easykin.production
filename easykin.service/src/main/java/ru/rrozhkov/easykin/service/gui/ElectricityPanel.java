package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.*;
import java.awt.*;

public class ElectricityPanel extends Panel{
	public static String PREV_MESURE_LABEL_TEXT = "Предыдущие показания";
	public static String CURRENT_MESURE_LABEL_TEXT = "Текущиу показания";
	public static String RATE_LABEL_TEXT = "Тариф";
	public static String ODN_LABEL_TEXT = "ОДН";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField rateField = null;
	private JTextField odnField = null;
	private Component prevMesureLabel = null;
	private Component currentMesureLabel = null;
	private Component rateLabel = null;
	private Component odnLabel = null;
	
	public ElectricityPanel(Panel parent, ICalculation bean) {
		super(parent, bean);
		fill();	 
	}

	private void fill() {
		setLayout(guiFactory.gridLayout(7, 2));
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getPrevMesureLabel()); 
		add(getPrevMesureField()); 
		add(getCurrentMesureLabel()); 
		add(getCurrentMesureField()); 
		add(getRateLabel()); 
		add(getRateField()); 
		add(getOdnLabel()); 
		add(getOdnField());
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getPrevMeasure());
			prevMesureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMesureField.getDocument().addDocumentListener(this);
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getCurrentMeasure());
			currentMesureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMesureField.getDocument().addDocumentListener(this);
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getRate());
			rateField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
	}

	public JTextField getOdnField(){
		if(odnField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getOdn());
			odnField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			odnField.getDocument().addDocumentListener(this);
		}
		return odnField;
	}
	
	public Component getPrevMesureLabel(){
		if(prevMesureLabel == null)
			prevMesureLabel = guiFactory.label(PREV_MESURE_LABEL_TEXT);
		return prevMesureLabel;
	}
	
	public Component getCurrentMesureLabel(){
		if(currentMesureLabel == null)
			currentMesureLabel = guiFactory.label(CURRENT_MESURE_LABEL_TEXT);
		return currentMesureLabel;
	}
	
	public Component getRateLabel(){
		if(rateLabel == null)
			rateLabel = guiFactory.label(RATE_LABEL_TEXT);
		return rateLabel;
	}

	public Component getOdnLabel(){
		if(odnLabel == null)
			odnLabel = guiFactory.label(ODN_LABEL_TEXT);
		return odnLabel;
	}

	@Override
	public void updateBean() {
		ElectricityCalc bean = (ElectricityCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}