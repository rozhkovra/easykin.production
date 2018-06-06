package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.gaz.GazCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.*;
import java.awt.*;

public class GazPanel extends Panel{ 
	public static String PREV_MESURE_LABEL_TEXT = "Предыдущие показания";
	public static String CURRENT_MESURE_LABEL_TEXT = "Текущие показания";
	public static String RATE_LABEL_TEXT = "Тариф";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField rateField = null;
	private Component prevMesureLabel = null;
	private Component currentMesureLabel = null;
	private Component rateLabel = null;
	
	public GazPanel(Panel parent, ICalculation calcBean) {
		super(parent, calcBean);
		fill();
	}

	private void fill() {
		setLayout(guiFactory.gridLayout(7, 2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getPrevMesureLabel()); 
		add(getPrevMesureField()); 
		add(getCurrentMesureLabel()); 
		add(getCurrentMesureField()); 
		add(getRateLabel()); 
		add(getRateField()); 
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			String text = String.valueOf(((GazCalc)calc).getPrevMeasure());
			prevMesureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMesureField.getDocument().addDocumentListener(this);
		}
		return prevMesureField;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			String text = String.valueOf(((GazCalc)calc).getCurrentMeasure());
			currentMesureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMesureField.getDocument().addDocumentListener(this);
		}
		return currentMesureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((GazCalc)calc).getRate());
			rateField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
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

	@Override
	public void updateBean() {
		GazCalc bean = (GazCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}