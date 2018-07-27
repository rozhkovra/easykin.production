package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.core.collection.CollectionUtil;
import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.ElectricityCalc;
import ru.rrozhkov.easykin.model.service.calc.impl.MeasureCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.JTextField;
import java.awt.Component;


public class ElectricityPanel extends Panel{
	private static final long serialVersionUID = 1L;
	private JTextField prevMeasureField;
	private JTextField currentMeasureField;
	private JTextField rateField;
	private Component prevMeasureLabel;
	private Component currentMeasureLabel;
	private Component rateLabel;

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
		add(guiFactory.labelEmpty());
		add(getItogoLabel()); 
		refresh();
	}
	
	public JTextField getPrevMeasureField(){
		if(prevMeasureField == null){
			String text = String.valueOf(((MeasureCalc)calc).getPrevMeasure());
			prevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMeasureField.getDocument().addDocumentListener(this);
		}
		return prevMeasureField;
	}

	public JTextField getCurrentMeasureField(){
		if(currentMeasureField == null){
			String text = String.valueOf(((MeasureCalc)calc).getCurrentMeasure());
			currentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMeasureField.getDocument().addDocumentListener(this);
		}
		return currentMeasureField;
	}
	
	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((MeasureCalc)calc).getRate());
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
			currentMeasureLabel = guiFactory.label("Текущиу показания");
		return currentMeasureLabel;
	}
	
	public Component getRateLabel(){
		if(rateLabel == null)
			rateLabel = guiFactory.label("Тариф");
		return rateLabel;
	}

	@Override
	public void updateBean() {
		ElectricityCalc bean = (ElectricityCalc)getCalc();
		bean.setPrevMeasure(CollectionUtil.create(CalcUtil.intNUllOrEmpty(getPrevMeasureField().getText())));
		bean.setCurrentMeasure(CollectionUtil.create(CalcUtil.intNUllOrEmpty(getCurrentMeasureField().getText())));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
	}
}