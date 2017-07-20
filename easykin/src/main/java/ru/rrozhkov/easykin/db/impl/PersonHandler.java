package ru.rrozhkov.easykin.db.impl;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.impl.convert.AuthDBPersonConverter;

public class PersonHandler {
	public static String select = "select * from PERSON";
	
	public static Collection<IPerson> select() throws SQLException {
		return EasyKinDBManager.instance().select(select,new AuthDBPersonConverter());
	}
}