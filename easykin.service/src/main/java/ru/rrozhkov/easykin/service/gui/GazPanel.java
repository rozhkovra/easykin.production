package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.GazCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.JTextField;
import java.awt.Component;

public class GazPanel extends Panel{ 
	private static final long serialVersionUID = 1L;
	private JTextField prevMeasureField = null;
	private JTextField currentMeasureField = null;
	private JTextField rateField = null;
	private Component prevMeasureLabel = null;
	private Component currentMeasureLabel = null;
	private Component rateLabel = null;
	
	public static GUIPanel create(GUIPanel parent, ICalculation calcBean) {
		GUIPanel panel = new GazPanel(parent, calcBean);
		panel.fill();
		return panel;
	}

	private GazPanel(GUIPanel parent, ICalculation calcBean) {
		super(parent, calcBean);
	}

	public void fill() {
		setLayout(guiFactory.gridLayout(7, 2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getPrevMeasureLabel());
		add(getPrevMeasureField());
		add(getCurrentMeasureLabel());
		add(getCurrentMeasureField());
		add(getRateLabel()); 
		add(getRateField()); 
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMeasureField(){
		if(prevMeasureField == null){
			String text = String.valueOf(((GazCalc)calc).getPrevMeasure());
			prevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMeasureField.getDocument().addDocumentListener(this);
		}
		return prevMeasureField;
	}

	public JTextField getCurrentMeasureField(){
		if(currentMeasureField == null){
			String text = String.valueOf(((GazCalc)calc).getCurrentMeasure());
			currentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMeasureField.getDocument().addDocumentListener(this);
		}
		return currentMeasureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((GazCalc)calc).getRate());
			rateField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
	}
	
	public Component getPrevMeasureLabel(){
		if(prevMeasureLabel == null)
			prevMeasureLabel = guiFactory.label("Предыдущие показания");
		return prevMeasureLabel;
	}
	
	public Component getCurrentMeasureLabel(){
		if(currentMeasureLabel == null)
			currentMeasureLabel = guiFactory.label("Текущие показания");
		return currentMeasureLabel;
	}
	
	public Component getRateLabel(){
		if(rateLabel == null)
			rateLabel = guiFactory.label("Тариф");
		return rateLabel;
	}

	@Override
	public void updateBean() {
		GazCalc bean = (GazCalc)getCalc();
//		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMeasureField().getText()));
//		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMeasureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}