package ru.rrozhkov.easykin.db.impl;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.impl.convert.DBKinPersonConverter;

public class KinPersonHandler {
	public static String select = "select * from PERSON inner join KINPERSON on PERSON.id = KINPERSON.person";
	
	public static Collection<IKinPerson> select() throws SQLException {
		return EasyKinDBManager.instance().select(select,new DBKinPersonConverter());
	}
}
