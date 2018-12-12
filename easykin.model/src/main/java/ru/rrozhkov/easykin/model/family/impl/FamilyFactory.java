package ru.rrozhkov.easykin.model.family.impl;

import ru.rrozhkov.easykin.model.family.IFamily;
import ru.rrozhkov.easykin.model.family.IKinPerson;
import ru.rrozhkov.easykin.model.family.KinType;
import ru.rrozhkov.easykin.model.person.Sex;

import java.sql.Date;
import java.util.Collection;

public class FamilyFactory {
	private static class Holder {
		private static final FamilyFactory INSTANCE = new FamilyFactory();
	}

	public static FamilyFactory instance(){
		return Holder.INSTANCE;
	}

	private FamilyFactory() {
	}

	public IFamily createFamily(Collection<IKinPerson> persons){
		return new Family(persons);
	}
	public IKinPerson create(int id, String surname, String name,
			String secondName, Date date, Sex sex, KinType kinType) {
		return new KinPerson(id, surname,name,secondName,date,sex,kinType);
	}
}