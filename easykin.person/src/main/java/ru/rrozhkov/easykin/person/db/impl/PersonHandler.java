package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

public class PersonHandler {
	private static final IDBManager dbManager = DBManager.instance();
	private static final PersonConverterFactory converterFactory = new PersonConverterFactory();

	public static String select = "select * from PERSON";
	
	public static Collection<IPerson> select() throws Exception {
		return dbManager.select(select, converterFactory.person());
	}
}