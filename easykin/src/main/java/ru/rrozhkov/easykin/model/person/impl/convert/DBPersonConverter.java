package ru.rrozhkov.easykin.model.person.impl.convert;

import java.sql.ResultSet;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.lib.convert.IConverter;

public class DBPersonConverter implements IConverter<ResultSet, IPerson> {

	public IPerson convert(ResultSet entry) {
		try{
			return PersonFactory.create(entry.getInt("id"), entry.getString("surname"), entry.getString("name")
				, entry.getString("secondName"), entry.getDate("birthdate"), Sex.sex(entry.getString("sex")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}