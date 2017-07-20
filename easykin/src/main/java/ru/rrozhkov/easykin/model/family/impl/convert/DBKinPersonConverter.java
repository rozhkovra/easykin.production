package ru.rrozhkov.easykin.model.family.impl.convert;

import java.sql.ResultSet;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.FamilyFactory;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.lib.convert.IConverter;

public class DBKinPersonConverter implements IConverter<ResultSet, IKinPerson> {

	public IKinPerson convert(ResultSet entry) {
		try{
			return FamilyFactory.create(entry.getInt("id"), entry.getString("surname"), entry.getString("name")
				, entry.getString("secondName"), entry.getDate("birthdate")
				, Sex.sex(entry.getString("sex")), KinType.kin(entry.getString("kinType")));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}