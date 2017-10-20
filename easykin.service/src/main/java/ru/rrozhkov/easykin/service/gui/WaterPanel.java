package ru.rrozhkov.easykin.service.gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import ru.rrozhkov.easykin.service.gui.util.CalcUtil;
import ru.rrozhkov.lib.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;

public class WaterPanel extends Panel{
	public static String COLD_PREV_MESURE_LABEL_TEXT = "Хол. пред. сч1";
	public static String COLD_CURRENT_MESURE_LABEL_TEXT = "Хол. тек. сч1";
	public static String HOT_PREV_MESURE_LABEL_TEXT = "Гор. пред. сч1";
	public static String HOT_CURRENT_MESURE_LABEL_TEXT = "Гор. тек. сч1";
	public static String COLD_PREV_MESURE_LABEL_TEXT2 = "Хол. пред. сч2";
	public static String COLD_CURRENT_MESURE_LABEL_TEXT2 = "Хол. тек. сч2";
	public static String HOT_PREV_MESURE_LABEL_TEXT2 = "Гор. пред. сч2";
	public static String HOT_CURRENT_MESURE_LABEL_TEXT2 = "Гор. тек. сч2";
	public static String RATE_IN_LABEL_TEXT = "Тариф вход";
	public static String RATE_OUT_LABEL_TEXT = "Тариф отвод";
	private static final long serialVersionUID = 1L;
	private JTextField coldPrevMesureField = null;
	private JTextField coldCurrentMesureField = null;
	private JTextField hotPrevMesureField = null;
	private JTextField hotCurrentMesureField = null;
	private JTextField coldPrevMesureField2 = null;
	private JTextField coldCurrentMesureField2 = null;
	private JTextField hotPrevMesureField2 = null;
	private JTextField hotCurrentMesureField2 = null;
	private JTextField rateInField = null;
	private JTextField rateOutField = null;
	private JLabel coldPrevMesureLabel = null;
	private JLabel coldCurrentMesureLabel = null;
	private JLabel hotPrevMesureLabel = null;
	private JLabel hotCurrentMesureLabel = null;
	private JLabel coldPrevMesureLabel2 = null;
	private JLabel coldCurrentMesureLabel2 = null;
	private JLabel hotPrevMesureLabel2 = null;
	private JLabel hotCurrentMesureLabel2 = null;
	private JLabel rateInLabel = null;
	private JLabel rateOutLabel = null;

	public WaterPanel(Panel parent, WaterCalc calcBean) {
		super(parent, calcBean);
		fill();	 
	}

	private void fill() {
		setLayout(new GridLayout(15, 2));
		add(getCalcTypeLabel());
		add(GuiUtil.labelEmpty());
		add(getColdPrevMesureLabel());
		add(getColdPrevMesureField()); 
		add(getColdCurrentMesureLabel()); 
		add(getColdCurrentMesureField());
		add(getColdPrevMesureLabel2());
		add(getColdPrevMesureField2());
		add(getColdCurrentMesureLabel2());
		add(getColdCurrentMesureField2());
		add(getHotPrevMesureLabel());
		add(getHotPrevMesureField()); 
		add(getHotCurrentMesureLabel()); 
		add(getHotCurrentMesureField());
		add(getHotPrevMesureLabel2());
		add(getHotPrevMesureField2());
		add(getHotCurrentMesureLabel2());
		add(getHotCurrentMesureField2());
		add(getRateInLabel());
		add(getRateInField());
		add(getRateOutLabel());
		add(getRateOutField()); 
		add(GuiUtil.labelEmpty());
		add(getItogoLabel());
		refresh();
	}

	public JTextField getRateOutField() {
		if(rateOutField == null){
			rateOutField = new JTextField(6);
			String text = String.valueOf(((WaterCalc)calc).getOutRate());
			rateOutField.setText(text);
			rateOutField.getDocument().addDocumentListener(this);
		}
		return rateOutField;
	}

	private Component getRateOutLabel() {
		if(rateOutLabel == null)
			rateOutLabel = new JLabel(RATE_OUT_LABEL_TEXT); 
		return rateOutLabel;
	}

	public JTextField getRateInField() {
		if(rateInField == null){
			rateInField = new JTextField(6);
			String text = String.valueOf(((WaterCalc)calc).getInRate());
			rateInField.setText(text);
			rateInField.getDocument().addDocumentListener(this);
		}
		return rateInField;
	}

	private Component getRateInLabel() {
		if(rateInLabel == null)
			rateInLabel = new JLabel(RATE_IN_LABEL_TEXT); 
		return rateInLabel;
	}

	public JTextField getHotCurrentMesureField() {
		if(hotCurrentMesureField == null){
			hotCurrentMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotCurrentMesure());
			hotCurrentMesureField.setText(text);
			hotCurrentMesureField.getDocument().addDocumentListener(this);
		}
		return hotCurrentMesureField;
	}
	public JTextField getHotCurrentMesureField2() {
		if(hotCurrentMesureField2 == null){
			hotCurrentMesureField2 = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotCurrentMesure2());
			hotCurrentMesureField2.setText(text);
			hotCurrentMesureField2.getDocument().addDocumentListener(this);
		}
		return hotCurrentMesureField2;
	}

	private Component getHotCurrentMesureLabel() {
		if(hotCurrentMesureLabel == null)
			hotCurrentMesureLabel = new JLabel(HOT_CURRENT_MESURE_LABEL_TEXT); 
		return hotCurrentMesureLabel;
	}

	private Component getHotCurrentMesureLabel2() {
		if(hotCurrentMesureLabel2 == null)
			hotCurrentMesureLabel2 = new JLabel(HOT_CURRENT_MESURE_LABEL_TEXT2);
		return hotCurrentMesureLabel2;
	}

	public JTextField getHotPrevMesureField() {
		if(hotPrevMesureField == null){
			hotPrevMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotPrevMesure());
			hotPrevMesureField.setText(text);
			hotPrevMesureField.getDocument().addDocumentListener(this);
		}
		return hotPrevMesureField;
	}

	public JTextField getHotPrevMesureField2() {
		if(hotPrevMesureField2 == null){
			hotPrevMesureField2 = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getHotPrevMesure2());
			hotPrevMesureField2.setText(text);
			hotPrevMesureField2.getDocument().addDocumentListener(this);
		}
		return hotPrevMesureField2;
	}

	private Component getHotPrevMesureLabel() {
		if(hotPrevMesureLabel == null)
			hotPrevMesureLabel = new JLabel(HOT_PREV_MESURE_LABEL_TEXT); 
		return hotPrevMesureLabel;
	}

	private Component getHotPrevMesureLabel2() {
		if(hotPrevMesureLabel2 == null)
			hotPrevMesureLabel2 = new JLabel(HOT_PREV_MESURE_LABEL_TEXT2);
		return hotPrevMesureLabel2;
	}

	public JTextField getColdPrevMesureField(){
		if(coldPrevMesureField == null){
			coldPrevMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdPrevMesure());
			coldPrevMesureField.setText(text);
			coldPrevMesureField.getDocument().addDocumentListener(this);
		}
		return coldPrevMesureField;
	}

	public JTextField getColdPrevMesureField2(){
		if(coldPrevMesureField2 == null){
			coldPrevMesureField2 = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdPrevMesure2());
			coldPrevMesureField2.setText(text);
			coldPrevMesureField2.getDocument().addDocumentListener(this);
		}
		return coldPrevMesureField2;
	}

	public JTextField getColdCurrentMesureField(){
		if(coldCurrentMesureField == null){
			coldCurrentMesureField = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdCurrentMesure());
			coldCurrentMesureField.setText(text);
			coldCurrentMesureField.getDocument().addDocumentListener(this);
		}
		return coldCurrentMesureField;
	}

	public JTextField getColdCurrentMesureField2(){
		if(coldCurrentMesureField2 == null){
			coldCurrentMesureField2 = new JTextField(5);
			String text = String.valueOf(((WaterCalc)calc).getColdCurrentMesure2());
			coldCurrentMesureField2.setText(text);
			coldCurrentMesureField2.getDocument().addDocumentListener(this);
		}
		return coldCurrentMesureField2;
	}

	public JLabel getColdPrevMesureLabel(){
		if(coldPrevMesureLabel == null)
			coldPrevMesureLabel = new JLabel(COLD_PREV_MESURE_LABEL_TEXT); 
		return coldPrevMesureLabel;
	}

	public JLabel getColdPrevMesureLabel2(){
		if(coldPrevMesureLabel2 == null)
			coldPrevMesureLabel2 = new JLabel(COLD_PREV_MESURE_LABEL_TEXT2);
		return coldPrevMesureLabel2;
	}

	public JLabel getColdCurrentMesureLabel(){
		if(coldCurrentMesureLabel == null)
			coldCurrentMesureLabel = new JLabel(COLD_CURRENT_MESURE_LABEL_TEXT);
		return coldCurrentMesureLabel;
	}

	public JLabel getColdCurrentMesureLabel2(){
		if(coldCurrentMesureLabel2 == null)
			coldCurrentMesureLabel2 = new JLabel(COLD_CURRENT_MESURE_LABEL_TEXT2);
		return coldCurrentMesureLabel2;
	}

	@Override
	public void updateBean() {
		WaterCalc bean = (WaterCalc)getCalc();
		bean.setColdPrevMesure(CalcUtil.doubleNUllOrEmpty(getColdPrevMesureField().getText()));
		bean.setColdCurrentMesure(CalcUtil.doubleNUllOrEmpty(getColdCurrentMesureField().getText()));
		bean.setHotPrevMesure(CalcUtil.doubleNUllOrEmpty(getHotPrevMesureField().getText()));
		bean.setHotCurrentMesure(CalcUtil.doubleNUllOrEmpty(getHotCurrentMesureField().getText()));
		bean.setColdPrevMesure2(CalcUtil.doubleNUllOrEmpty(getColdPrevMesureField2().getText()));
		bean.setColdCurrentMesure2(CalcUtil.doubleNUllOrEmpty(getColdCurrentMesureField2().getText()));
		bean.setHotPrevMesure2(CalcUtil.doubleNUllOrEmpty(getHotPrevMesureField2().getText()));
		bean.setHotCurrentMesure2(CalcUtil.doubleNUllOrEmpty(getHotCurrentMesureField2().getText()));
		bean.setInRate(CalcUtil.moneyNUllOrEmpty(getRateInField().getText()));
		bean.setOutRate(CalcUtil.moneyNUllOrEmpty(getRateOutField().getText()));
	}
}