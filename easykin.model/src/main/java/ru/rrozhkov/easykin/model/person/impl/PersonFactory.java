package ru.rrozhkov.easykin.model.person.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;

import java.util.Date;

public class PersonFactory {
	public static IPerson create(int id, String surname, String name, String secondName, Date birthDate, Sex sex){
		return new Person(id, surname, name, secondName, birthDate, sex);
	}
	public static IPerson create(int id, String surname, String name, String secondName, Date birthDate, Sex sex, String username, String password){
		return new Person(id, surname, name, secondName, birthDate, sex, username, password);
	}
}
