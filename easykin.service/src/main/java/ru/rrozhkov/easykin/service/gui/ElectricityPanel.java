package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.electricity.ElectricityCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.JTextField;
import java.awt.Component;


public class ElectricityPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private JTextField prevMeasureField;
	private JTextField currentMeasureField;
	private JTextField rateField;
	private JTextField odnField;
	private Component prevMeasureLabel;
	private Component currentMeasureLabel;
	private Component rateLabel;
	private Component odnLabel;
	
	public static GUIPanel create(GUIPanel parent, ICalculation bean) {
		GUIPanel panel = new ElectricityPanel(parent, bean);
		panel.fill();
		return panel;
	}

	private ElectricityPanel(GUIPanel parent, ICalculation bean) {
		super(parent, bean);
	}

	public void fill() {
		setLayout(guiFactory.gridLayout(7, 2));
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getPrevMeasureLabel());
		add(getPrevMeasureField());
		add(getCurrentMeasureLabel());
		add(getCurrentMeasureField());
		add(getRateLabel()); 
		add(getRateField()); 
		add(getOdnLabel()); 
		add(getOdnField());
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMeasureField(){
		if(prevMeasureField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getPrevMeasure());
			prevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMeasureField.getDocument().addDocumentListener(this);
		}
		return prevMeasureField;
	}

	public JTextField getCurrentMeasureField(){
		if(currentMeasureField == null){
			String text = String.valueOf(((ElectricityCalc)calc).getCurrentMeasure());
			currentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMeasureField.getDocument().addDocumentListener(this);
		}
		return currentMeasureField;
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
	
	public Component getPrevMeasureLabel(){
		if(prevMeasureLabel == null)
			prevMeasureLabel = guiFactory.label("Предыдущие показания");
		return prevMeasureLabel;
	}
	
	public Component getCurrentMeasureLabel(){
		if(currentMeasureLabel == null)
			currentMeasureLabel = guiFactory.label("Текущиу показания");
		return currentMeasureLabel;
	}
	
	public Component getRateLabel(){
		if(rateLabel == null)
			rateLabel = guiFactory.label("Тариф");
		return rateLabel;
	}

	public Component getOdnLabel(){
		if(odnLabel == null)
			odnLabel = guiFactory.label("ОДН");
		return odnLabel;
	}

	@Override
	public void updateBean() {
		ElectricityCalc bean = (ElectricityCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMeasureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMeasureField().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}