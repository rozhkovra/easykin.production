package ru.rrozhkov.easykin.service.gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.service.gui.util.CalcUtil;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.water.hot.HotWaterCalc;

public class HotWaterPanel extends Panel{ 
	public static String PREV_MESURE_LABEL_TEXT = "Пред. показания 1 сч";
	public static String CURRENT_MESURE_LABEL_TEXT = "Тек. показания 1 сч";
	public static String PREV_MESURE_LABEL_TEXT2 = "Пред. показания 2 сч";
	public static String CURRENT_MESURE_LABEL_TEXT2 = "Тек. показания 2 сч";
	public static String RATE_LABEL_TEXT = "Тариф";
	public static String ODN_LABEL_TEXT = "ОДН";
	private static final long serialVersionUID = 1L;
	private JTextField prevMesureField = null;
	private JTextField currentMesureField = null;
	private JTextField prevMesureField2 = null;
	private JTextField currentMesureField2 = null;
	private JTextField rateField = null;
	private JTextField odnField = null;
	private JLabel prevMesureLabel = null;
	private JLabel currentMesureLabel = null;
	private JLabel prevMesureLabel2 = null;
	private JLabel currentMesureLabel2 = null;
	private JLabel rateLabel = null;
	private JLabel odnLabel = null;
	
	public HotWaterPanel(Panel parent, HotWaterCalc calcBean) {
		super(parent, calcBean);
		fill();	 
	}

	private void fill() {
		setLayout(new GridLayout(10, 2));

		add(getCalcTypeLabel());
		add(GuiUtil.labelEmpty());
		add(getPrevMesureLabel());
		add(getPrevMesureField());
		add(getCurrentMesureLabel());
		add(getCurrentMesureField());
		add(getPrevMesureLabel2());
		add(getPrevMesureField2());
		add(getCurrentMesureLabel2());
		add(getCurrentMesureField2());
		add(getRateLabel());
		add(getRateField()); 
		add(getOdnLabel()); 
		add(getOdnField());
		add(GuiUtil.labelEmpty());
		add(getItogoLabel());
		refresh();
	}
	
	public JTextField getPrevMesureField(){
		if(prevMesureField == null){
			String text = String.valueOf(((HotWaterCalc)calc).getPrevMeasure());
			prevMesureField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			prevMesureField.getDocument().addDocumentListener(this);
		}
		return prevMesureField;
	}

	public JTextField getPrevMesureField2(){
		if(prevMesureField2 == null){
			String text = String.valueOf(((HotWaterCalc)calc).getPrevMeasure2());
			prevMesureField2 = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			prevMesureField2.getDocument().addDocumentListener(this);
		}
		return prevMesureField2;
	}

	public JTextField getCurrentMesureField(){
		if(currentMesureField == null){
			String text = String.valueOf(((HotWaterCalc)calc).getCurrentMeasure());
			currentMesureField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			currentMesureField.getDocument().addDocumentListener(this);
		}
		return currentMesureField;
	}

	public JTextField getCurrentMesureField2(){
		if(currentMesureField2 == null){
			String text = String.valueOf(((HotWaterCalc)calc).getCurrentMeasure2());
			currentMesureField2 = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			currentMesureField2.getDocument().addDocumentListener(this);
		}
		return currentMesureField2;
	}

	public JTextField getRateField(){
		if(rateField == null){
			String text = String.valueOf(((HotWaterCalc)calc).getRate());
			rateField = (JTextField) GuiUtil.fieldCalc(5, text, calc.isPaid());
			rateField.getDocument().addDocumentListener(this);
		}
		return rateField;
	}

	public JTextField getOdnField(){
		if(odnField == null){
			odnField = (JTextField) GuiUtil.fieldCalc(5, "", calc.isPaid());
//			String text = String.valueOf(((HotWaterCalc)calc).getOdn());
//			odnField.setText(text);
			odnField.getDocument().addDocumentListener(this);
		}
		return odnField;
	}
	
	public JLabel getPrevMesureLabel(){
		if(prevMesureLabel == null)
			prevMesureLabel = (JLabel)GuiUtil.label(PREV_MESURE_LABEL_TEXT);
		return prevMesureLabel;
	}
	
	public JLabel getCurrentMesureLabel(){
		if(currentMesureLabel == null)
			currentMesureLabel = (JLabel)GuiUtil.label(CURRENT_MESURE_LABEL_TEXT);
		return currentMesureLabel;
	}

	public JLabel getPrevMesureLabel2(){
		if(prevMesureLabel2 == null)
			prevMesureLabel2 = (JLabel)GuiUtil.label(PREV_MESURE_LABEL_TEXT2);
		return prevMesureLabel2;
	}

	public JLabel getCurrentMesureLabel2(){
		if(currentMesureLabel2 == null)
			currentMesureLabel2 = (JLabel)GuiUtil.label(CURRENT_MESURE_LABEL_TEXT2);
		return currentMesureLabel2;
	}

	public JLabel getRateLabel(){
		if(rateLabel == null)
			rateLabel = (JLabel)GuiUtil.label(RATE_LABEL_TEXT);
		return rateLabel;
	}

	public JLabel getOdnLabel(){
		if(odnLabel == null)
			odnLabel = (JLabel)GuiUtil.label(ODN_LABEL_TEXT);
		return odnLabel;
	}

	@Override
	public void updateBean() {
		HotWaterCalc bean = (HotWaterCalc)getCalc();
		bean.setPrevMeasure(CalcUtil.doubleNUllOrEmpty(getPrevMesureField().getText()));
		bean.setCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField().getText()));
		bean.setPrevMeasure2(CalcUtil.doubleNUllOrEmpty(getPrevMesureField2().getText()));
		bean.setCurrentMeasure2(CalcUtil.doubleNUllOrEmpty(getCurrentMesureField2().getText()));
		bean.setRate(CalcUtil.moneyNUllOrEmpty(getRateField().getText()));
//		bean.setOdn(CalcUtil.moneyNUllOrEmpty(getOdnField().getText()));
	}
}