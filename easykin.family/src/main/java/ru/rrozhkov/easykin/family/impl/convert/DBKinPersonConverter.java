package ru.rrozhkov.easykin.family.impl.convert;

import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.family.impl.FamilyFactory;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.lib.convert.IConverter;
import ru.rrozhkov.lib.convert.IEntityConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

public class DBKinPersonConverter implements IEntityConverter<IKinPerson> {
	final static private FamilyFactory familyFactory = FamilyFactory.instance();

	public String sqlInsert(IKinPerson entity) {
		return "";
	}

	public Map<String, Object> map(IKinPerson entity) {
		return null;
	}

	public String[] stringArr(Collection<IKinPerson> entries) {
		return new String[0];
	}

	public IKinPerson entity(ResultSet resultSet) {
		return new IConverter<ResultSet, IKinPerson>() {
			public IKinPerson convert(ResultSet entry){
				try{
					return familyFactory.create(entry.getInt("id"), entry.getString("surname"), entry.getString("name")
							, entry.getString("secondName"), entry.getDate("birthdate")
							, Sex.sex(entry.getString("sex")), KinType.kin(entry.getString("kinType")));
				}catch(SQLException e){
					e.printStackTrace();
				}
				return null;
			}
		}.convert(resultSet);
	}
}