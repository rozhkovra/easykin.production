package ru.rrozhkov.easykin.model.person.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.Date;

public class Person implements IPerson {
	private int id;
	private String surname;
	private String name;
	private String secondName;
	private Date birthDate;
	private Sex sex;
	private String username;
	private String password;
	
	public Person(int id, String surname, String name, String secondName, Date birthDate, Sex sex) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.sex = sex;
	}

	public Person(int id, String surname, String name, String secondName, Date birthDate, Sex sex, String username, String password) {
		this.id = id;
		this.surname = surname;
		this.name = name;
		this.secondName = secondName;
		this.birthDate = birthDate;
		this.sex = sex;
		this.username = username;
		this.password = password;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getSecondName() {
		return secondName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public Sex getSex() {
		return sex;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return surname + ", " + name
				+ ", " + secondName + ", " + DateUtil.format(birthDate)
				+ ", " + sex;
	}

	public int getId() {
		return id;
	}
}