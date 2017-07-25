package ru.rrozhkov.easykin.family.db.impl;

import ru.rrozhkov.easykin.family.impl.convert.DBKinPersonConverter;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

public class KinPersonHandler {
	public static String select = "select * from PERSON inner join KINPERSON on PERSON.id = KINPERSON.person";
	
	public static Collection<IKinPerson> select() throws Exception {
		return DBManager.instance().select(select,new DBKinPersonConverter());
	}
}
