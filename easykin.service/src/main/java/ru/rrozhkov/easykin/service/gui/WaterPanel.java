package ru.rrozhkov.easykin.service.gui;

import ru.rrozhkov.easykin.model.service.calc.ICalculation;
import ru.rrozhkov.easykin.model.service.calc.impl.water.WaterCalc;
import ru.rrozhkov.easykin.service.gui.util.CalcUtil;

import javax.swing.JTextField;
import java.awt.Component;

public class WaterPanel extends Panel {
	private static final long serialVersionUID = 1L;
	private JTextField coldPrevMeasureField;
	private JTextField coldCurrentMeasureField;
	private JTextField hotPrevMeasureField;
	private JTextField hotCurrentMeasureField;
	private JTextField coldPrevMeasureField2;
	private JTextField coldCurrentMeasureField2;
	private JTextField hotPrevMeasureField2;
	private JTextField hotCurrentMeasureField2;
	private JTextField rateInField;
	private JTextField rateOutField;
	private Component coldPrevMeasureLabel;
	private Component coldCurrentMeasureLabel;
	private Component hotPrevMeasureLabel;
	private Component hotCurrentMeasureLabel;
	private Component coldPrevMeasureLabel2;
	private Component coldCurrentMeasureLabel2;
	private Component hotPrevMeasureLabel2;
	private Component hotCurrentMeasureLabel2;
	private Component rateInLabel;
	private Component rateOutLabel;

	public static GUIPanel create(GUIPanel parent, ICalculation calcBean) {
		GUIPanel panel = new WaterPanel(parent, calcBean);
		panel.fill();
		return panel;
	}

	private WaterPanel(GUIPanel parent, ICalculation calcBean) {
		super(parent, calcBean);
	}

	public void fill() {
		setLayout(guiFactory.gridLayout(15, 2));
		add(getCalcTypeLabel());
		add(guiFactory.labelEmpty());
		add(getColdPrevMeasureLabel());
		add(getColdPrevMeasureField());
		add(getColdCurrentMeasureLabel());
		add(getColdCurrentMeasureField());
		add(getColdPrevMeasureLabel2());
		add(getColdPrevMeasureField2());
		add(getColdCurrentMeasureLabel2());
		add(getColdCurrentMeasureField2());
		add(getHotPrevMeasureLabel());
		add(getHotPrevMeasureField());
		add(getHotCurrentMeasureLabel());
		add(getHotCurrentMeasureField());
		add(getHotPrevMeasureLabel2());
		add(getHotPrevMeasureField2());
		add(getHotCurrentMeasureLabel2());
		add(getHotCurrentMeasureField2());
		add(getRateInLabel());
		add(getRateInField());
		add(getRateOutLabel());
		add(getRateOutField()); 
		add(guiFactory.labelEmpty());
		add(getItogoLabel());
		refresh();
	}

	public JTextField getRateOutField() {
		if(rateOutField == null){
			String text = String.valueOf(((WaterCalc)calc).getOutRate());
			rateOutField = (JTextField) guiFactory.fieldCalc(6, text, calc.isPaid());
			rateOutField.getDocument().addDocumentListener(this);
		}
		return rateOutField;
	}

	private Component getRateOutLabel() {
		if(rateOutLabel == null)
			rateOutLabel = guiFactory.label("Тариф отвод");
		return rateOutLabel;
	}

	public JTextField getRateInField() {
		if(rateInField == null){
			String text = String.valueOf(((WaterCalc)calc).getInRate());
			rateInField = (JTextField) guiFactory.fieldCalc(6, text, calc.isPaid());
			rateInField.getDocument().addDocumentListener(this);
		}
		return rateInField;
	}

	private Component getRateInLabel() {
		if(rateInLabel == null)
			rateInLabel = guiFactory.label("Тариф вход");
		return rateInLabel;
	}

	public JTextField getHotCurrentMeasureField() {
		if(hotCurrentMeasureField == null){
			String text = String.valueOf(((WaterCalc)calc).getHotCurrentMeasure(0));
			hotCurrentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			hotCurrentMeasureField.getDocument().addDocumentListener(this);
		}
		return hotCurrentMeasureField;
	}
	public JTextField getHotCurrentMeasureField2() {
		if(hotCurrentMeasureField2 == null){
			String text = String.valueOf(((WaterCalc)calc).getHotCurrentMeasure(1));
			hotCurrentMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			hotCurrentMeasureField2.getDocument().addDocumentListener(this);
		}
		return hotCurrentMeasureField2;
	}

	private Component getHotCurrentMeasureLabel() {
		if(hotCurrentMeasureLabel == null)
			hotCurrentMeasureLabel = guiFactory.label("Гор. тек. сч1");
		return hotCurrentMeasureLabel;
	}

	private Component getHotCurrentMeasureLabel2() {
		if(hotCurrentMeasureLabel2 == null)
			hotCurrentMeasureLabel2 = guiFactory.label("Гор. тек. сч2");
		return hotCurrentMeasureLabel2;
	}

	public JTextField getHotPrevMeasureField() {
		if(hotPrevMeasureField == null){
			String text = String.valueOf(((WaterCalc)calc).getHotPrevMeasure(0));
			hotPrevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			hotPrevMeasureField.getDocument().addDocumentListener(this);
		}
		return hotPrevMeasureField;
	}

	public JTextField getHotPrevMeasureField2() {
		if(hotPrevMeasureField2 == null){
			String text = String.valueOf(((WaterCalc)calc).getHotPrevMeasure(1));
			hotPrevMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			hotPrevMeasureField2.getDocument().addDocumentListener(this);
		}
		return hotPrevMeasureField2;
	}

	private Component getHotPrevMeasureLabel() {
		if(hotPrevMeasureLabel == null)
			hotPrevMeasureLabel = guiFactory.label("Гор. пред. сч1");
		return hotPrevMeasureLabel;
	}

	private Component getHotPrevMeasureLabel2() {
		if(hotPrevMeasureLabel2 == null)
			hotPrevMeasureLabel2 = guiFactory.label("Гор. пред. сч2");
		return hotPrevMeasureLabel2;
	}

	public JTextField getColdPrevMeasureField(){
		if(coldPrevMeasureField == null){
			String text = String.valueOf(((WaterCalc)calc).getColdPrevMeasure(0));
			coldPrevMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			coldPrevMeasureField.getDocument().addDocumentListener(this);
		}
		return coldPrevMeasureField;
	}

	public JTextField getColdPrevMeasureField2(){
		if(coldPrevMeasureField2 == null){
			String text = String.valueOf(((WaterCalc)calc).getColdPrevMeasure(1));
			coldPrevMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			coldPrevMeasureField2.getDocument().addDocumentListener(this);
		}
		return coldPrevMeasureField2;
	}

	public JTextField getColdCurrentMeasureField(){
		if(coldCurrentMeasureField == null){
			String text = String.valueOf(((WaterCalc)calc).getColdCurrentMeasure(0));
			coldCurrentMeasureField = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			coldCurrentMeasureField.getDocument().addDocumentListener(this);
		}
		return coldCurrentMeasureField;
	}

	public JTextField getColdCurrentMeasureField2(){
		if(coldCurrentMeasureField2 == null){
			String text = String.valueOf(((WaterCalc)calc).getColdCurrentMeasure(1));
			coldCurrentMeasureField2 = (JTextField) guiFactory.fieldCalc(5, text, calc.isPaid());
			coldCurrentMeasureField2.getDocument().addDocumentListener(this);
		}
		return coldCurrentMeasureField2;
	}

	public Component getColdPrevMeasureLabel(){
		if(coldPrevMeasureLabel == null)
			coldPrevMeasureLabel = guiFactory.label("Хол. пред. сч1");
		return coldPrevMeasureLabel;
	}

	public Component getColdPrevMeasureLabel2(){
		if(coldPrevMeasureLabel2 == null)
			coldPrevMeasureLabel2 = guiFactory.label("Хол. пред. сч2");
		return coldPrevMeasureLabel2;
	}

	public Component getColdCurrentMeasureLabel(){
		if(coldCurrentMeasureLabel == null)
			coldCurrentMeasureLabel = guiFactory.label("Хол. тек. сч1");
		return coldCurrentMeasureLabel;
	}

	public Component getColdCurrentMeasureLabel2(){
		if(coldCurrentMeasureLabel2 == null)
			coldCurrentMeasureLabel2 = guiFactory.label("Хол. тек. сч2");
		return coldCurrentMeasureLabel2;
	}

	@Override
	public void updateBean() {
		WaterCalc bean = (WaterCalc)getCalc();
//		bean.setColdPrevMeasure(CalcUtil.doubleNUllOrEmpty(getColdPrevMeasureField().getText()));
//		bean.setColdCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getColdCurrentMeasureField().getText()));
//		bean.setHotPrevMeasure(CalcUtil.doubleNUllOrEmpty(getHotPrevMeasureField().getText()));
//		bean.setHotCurrentMeasure(CalcUtil.doubleNUllOrEmpty(getHotCurrentMeasureField().getText()));
//		bean.setColdPrevMeasure2(CalcUtil.doubleNUllOrEmpty(getColdPrevMeasureField2().getText()));
//		bean.setColdCurrentMeasure2(CalcUtil.doubleNUllOrEmpty(getColdCurrentMeasureField2().getText()));
//		bean.setHotPrevMeasure2(CalcUtil.doubleNUllOrEmpty(getHotPrevMeasureField2().getText()));
//		bean.setHotCurrentMeasure2(CalcUtil.doubleNUllOrEmpty(getHotCurrentMeasureField2().getText()));
//		bean.setInRate(CalcUtil.moneyNUllOrEmpty(getRateInField().getText()));
//		bean.setOutRate(CalcUtil.moneyNUllOrEmpty(getRateOutField().getText()));
	}
}