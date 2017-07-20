package ru.rrozhkov.easykin.gui.person;

import ru.rrozhkov.easykin.gui.Form;
import ru.rrozhkov.easykin.gui.IGUIEditor;
import ru.rrozhkov.easykin.gui.util.GuiUtil;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.lib.util.DateUtil;

import java.awt.*;

public class PersonForm extends Form {
	private static final long serialVersionUID = 1L;
	private Component surnameField;
	private Component nameField;
	private Component secondNameField;
	private Component birthDateField;
	private Component surnameLabel;
	private Component nameLabel;
	private Component secondNameLabel;
	private Component birthDateLabel;

	private IPerson person;

	public PersonForm(IGUIEditor parent, IPerson person) {
		super(parent);
		this.person = person;
		fill();
	}
	
	protected void fill(){
		setLayout(new GridLayout(7, 2));
		add(GuiUtil.labelEmpty());
		add(GuiUtil.labelEmpty());
		add(getSurnameLabel());
		add(getSurnameField());
		add(getNameLabel());
		add(getNameField());
		add(getSecondNameLabel());
		add(getSecondNameField());
		add(getBirthDateLabel());
		add(getBirthDateField());
		add(GuiUtil.labelEmpty());
		add(getCancelButton());
	}

	private Component getSurnameField(){
		if(surnameField == null){
			surnameField = GuiUtil.fieldReadOnly(50, person.getSurname());
		}
		return surnameField;
	}

	private Component getNameField(){
		if(nameField == null){
			nameField = GuiUtil.fieldReadOnly(50, person.getName());
		}
		return nameField;
	}

	private Component getSecondNameField(){
		if(secondNameField == null){
			secondNameField = GuiUtil.fieldReadOnly(50, person.getSecondName());
		}
		return secondNameField;
	}

	private Component getBirthDateField(){
		if(birthDateField == null){
			birthDateField = GuiUtil.fieldReadOnly(10, DateUtil.format(person.getBirthDate()));
		}
		return birthDateField;
	}

	private Component getSurnameLabel(){
		if(surnameLabel == null)
			surnameLabel = GuiUtil.label("Фамилия");
		return surnameLabel;
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = GuiUtil.label("Имя");
		return nameLabel;
	}

	private Component getSecondNameLabel(){
		if(secondNameLabel == null)
			secondNameLabel = GuiUtil.label("Отчество");
		return secondNameLabel;
	}

	private Component getBirthDateLabel(){
		if(birthDateLabel == null)
			birthDateLabel = GuiUtil.label("Дата рождения");
		return birthDateLabel;
	}
}