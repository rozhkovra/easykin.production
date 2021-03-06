package ru.rrozhkov.easykin.person.gui;

import ru.rrozhkov.easykin.core.gui.Form;
import ru.rrozhkov.easykin.core.gui.IGUIEditor;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.awt.Component;


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

	public static Form create(final IGUIEditor parent, final IPerson person) {
		Form form = new PersonForm(parent, person);
		form.fill();
		return form;
	}

	private PersonForm(IGUIEditor parent, IPerson person) {
		super(parent);
		this.person = person;
	}
	
	public void fill(){
		setLayout(guiFactory.gridLayout(7, 2));
		add(guiFactory.labelEmpty());
		add(guiFactory.labelEmpty());
		add(getSurnameLabel());
		add(getSurnameField());
		add(getNameLabel());
		add(getNameField());
		add(getSecondNameLabel());
		add(getSecondNameField());
		add(getBirthDateLabel());
		add(getBirthDateField());
		add(guiFactory.labelEmpty());
		add(getCancelButton());
	}

	private Component getSurnameField(){
		if(surnameField == null){
			surnameField = guiFactory.fieldReadOnly(50, person.getSurname());
		}
		return surnameField;
	}

	private Component getNameField(){
		if(nameField == null){
			nameField = guiFactory.fieldReadOnly(50, person.getName());
		}
		return nameField;
	}

	private Component getSecondNameField(){
		if(secondNameField == null){
			secondNameField = guiFactory.fieldReadOnly(50, person.getSecondName());
		}
		return secondNameField;
	}

	private Component getBirthDateField(){
		if(birthDateField == null){
			birthDateField = guiFactory.fieldReadOnly(10, DateUtil.format(person.getBirthDate()));
		}
		return birthDateField;
	}

	private Component getSurnameLabel(){
		if(surnameLabel == null)
			surnameLabel = guiFactory.label("Фамилия");
		return surnameLabel;
	}

	private Component getNameLabel(){
		if(nameLabel == null)
			nameLabel = guiFactory.label("Имя");
		return nameLabel;
	}

	private Component getSecondNameLabel(){
		if(secondNameLabel == null)
			secondNameLabel = guiFactory.label("Отчество");
		return secondNameLabel;
	}

	private Component getBirthDateLabel(){
		if(birthDateLabel == null)
			birthDateLabel = guiFactory.label("Дата рождения");
		return birthDateLabel;
	}
}