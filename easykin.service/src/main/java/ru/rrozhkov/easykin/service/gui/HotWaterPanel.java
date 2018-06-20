package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.JTextField;
import java.awt.Component;

public class HotWaterPanel extends Panel{ 
	private static final long serialVersionUID = 1L;
	private JTextField prevMeasureField;
	private JTextField currentMeasureField;
	private JTextField prevMeasureField2;
	private JTextField currentMeasureField2;
	private JTextField rateField;
	private JTextField odnField;
	private Component prevMeasureLabel;
	private Component currentMeasureLabel;
	private Component prevMeasureLabel2;
	private Component currentMeasureLabel2;
	private Component rateLabel;
	private Component odnLabel;
	
	public static GUIPanel create(GUIPanel parent, ICalculation calcBean) {
		GUIPanel panel = new HotWaterPanel(parent, calcBean);
		panel.fill();
		return panel;
	}

	private HotWaterPanel(GUIPanel parent, ICalculation calcBean) {
		super(parent, calcBean);
	}

	public void fill() {
		setLayout(guiFactory.gridLayout(10, 2));

		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getPrevMeasureLabel());
		add(getPrevMeasureField());
		add(getCurrentMeasureLabel());
		add(getCurrentMeasureField());
		add(getPrevMeasureLabel2());
		add(getPrevMeasureField2());
		add(getCurrentMeasureLabel2());
		add(getCurrentMeasureField2());
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
			String text = String.valueOf(((HotWaterCalc)calc).getPrevMeasure());
			prevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMeasureField.getDocument().addDocumentListener(this);
		}
		return prevMeasureField;
	}

	public JTextField getPrevMeasureField2(){
		if(prevMeasureField2 == null){
			String text = String.valueOf(((HotWaterCalc)calc).getPrevMeasure2());
			prevMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			prevMeasureField2.getDocument().addDocumentListener(this);
		}
		return prevMeasureField2;
	}

	public JTextField getCurrentMeasureField(){
		if(currentMeasureField == null){
			String text = String.valueOf(((HotWaterCalc)calc).getCurrentMeasure());
			currentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMeasureField.getDocument().addDocumentListener(this);
		}
		return currentMeasureField;
	}

	public JTextField getCurrentMeasureField2(){
		if(currentMeasureField2 == null){
			String text = String.valueOf(((HotWaterCalc)calc).getCurrentMeasure2());
			currentMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			currentMeasureField2.getDocument().addDocumentListener(this);
		}
		return currentMeasureField2;
	}

	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((HotWaterCalc)calc).getRate());
			rateField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
	}

	public JTextField getOdnField(){
		if(odnField == null){
			odnField = (JTextField) guiFactory.fieldCalc(5, "", calc.isPaid());
//			String text = String.valueOf(((HotWaterCalc)calc).getOdn());
//			odnField.setText(text);
			odnField.getDocument().addDocumentListener(this);
		}
		return odnField;
	}
	
	public Component getPrevMeasureLabel(){
		if(prevMeasureLabel == null)
			prevMeasureLabel = guiFactory.label("Пред. показания 1 сч");
		return prevMeasureLabel;
	}
	
	public Component getCurrentMeasureLabel(){
		if(currentMeasureLabel == null)
			currentMeasureLabel = guiFactory.label("Тек. показания 1 сч");
		return currentMeasureLabel;
	}

	public Component getPrevMeasureLabel2(){
		if(prevMeasureLabel2 == null)
			prevMeasureLabel2 = guiFactory.label("Пред. показания 2 сч");
		return prevMeasureLabel2;
	}

	public Component getCurrentMeasureLabel2(){
		if(currentMeasureLabel2 == null)
			currentMeasureLabel2 = guiFactory.label("Тек. показания 2 сч");
		return currentMeasureLabel2;
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
		HotWaterCalc bean = (HotWaterCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMeasureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMeasureField().getText()));
		bean.setPrevMeasure2(CalcUtil.doubleNUllOrEmpty(getPrevMeasureField2().getText()));
		bean.setCurrentMeasure2(CalcUtil.doubleNUllOrEmpty(getCurrentMeasureField2().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
//		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}