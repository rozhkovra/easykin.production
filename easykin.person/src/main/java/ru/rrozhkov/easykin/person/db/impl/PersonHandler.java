package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

public class PersonHandler {
	public static String select = "select * from PERSON";
	
	public static Collection<IPerson> select() throws Exception {
		return DBManager.instance().select(select, PersonConverterFactory.person());
	}
}