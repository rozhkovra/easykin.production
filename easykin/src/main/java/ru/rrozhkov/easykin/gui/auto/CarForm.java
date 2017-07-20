package ru.rrozhkov.easykin.gui.auto;

import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.auto.ICar;

import javax.swing.*;
import java.awt.*;

public class CarForm extends JPanel {
	private static final long serialVersionUID = 1L;
	private Component brendField = null;
	private Component modelField = null;
	private Component bodyField = null;
	private Component yearField = null;
	private Component volumeField = null;
	private Component brendLabel = null;
	private Component modelLabel = null;
	private Component bodyLabel = null;
	private Component yearLabel = null;
	private Component volumeLabel = null;
	private ICar car;
	public CarForm(ICar car) {
		this.car = car;
		
		setLayout(new GridLayout(5,2)); 		
 
		add(getBrendLabel()); 
		add(getBredField()); 
		add(getModelLabel()); 
		add(getModelField()); 
		add(getBodyLabel()); 
		add(getBodyField()); 
		add(getYearLabel()); 
		add(getYearField()); 
		add(getVolumeLabel()); 
		add(getVolumeField()); 
	}
	
	private Component getVolumeField() {
		if(volumeField == null){
			volumeField = GuiUtil.fieldReadOnly(10, String.valueOf(car.getVolume()));
		}
		return volumeField;
	}

	private Component getVolumeLabel() {
		if(volumeLabel == null)
			volumeLabel = GuiUtil.label("Объем");
		return volumeLabel;
	}

	private Component getYearField() {
		if(yearField == null){
			yearField = GuiUtil.fieldReadOnly(10, String.valueOf(car.getYear()));
		}
		return yearField;
	}

	private Component getYearLabel() {		
		if(yearLabel == null)
			yearLabel = GuiUtil.label("Год");
		return yearLabel;
	}

	public Component getBredField(){
		if(brendField == null){
			brendField = GuiUtil.fieldReadOnly(10, car.getBrend().toString());
		}
		return brendField;
	}

	public Component getModelField(){
		if(modelField == null){
			modelField = GuiUtil.fieldReadOnly(10, car.getModel().toString());
		}
		return modelField;
	}
	
	public Component getBodyField(){
		if(bodyField == null){
			bodyField = GuiUtil.fieldReadOnly(10, car.getBody().toString());
		}
		return bodyField;
	}
	
	public Component getBrendLabel(){
		if(brendLabel == null)
			brendLabel = GuiUtil.label("Марка");
		return brendLabel;
	}
	
	public Component getModelLabel(){
		if(modelLabel == null)
			modelLabel = GuiUtil.label("Модель");
		return modelLabel;
	}
	
	public Component getBodyLabel(){
		if(bodyLabel == null)
			bodyLabel = GuiUtil.label("Кузов");
		return bodyLabel;
	}
}