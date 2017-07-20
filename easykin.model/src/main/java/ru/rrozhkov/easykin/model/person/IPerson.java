package ru.rrozhkov.easykin.model.person;

import java.util.Date;

public interface IPerson{
	int getId();
	String getSurname();
	String getName();
	String getSecondName();
	Date getBirthDate();
	Sex getSex();
	String getUsername();
	String getPassword();
}