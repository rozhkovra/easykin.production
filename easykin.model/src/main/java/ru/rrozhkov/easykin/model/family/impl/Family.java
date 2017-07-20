package ru.rrozhkov.easykin.model.family.impl;

import ru.rrozhkov.easykin.model.family.IFamily;
import ru.rrozhkov.easykin.model.family.IKinPerson;

import java.util.Collection;

public class Family implements IFamily {
	private Collection<IKinPerson> persons;
	
	public Family(Collection<IKinPerson> persons) {
		this.persons = persons;
	}

	public Collection<IKinPerson> getPersons() {
		return persons;
	}

	@Override
	public String toString() {
		return "Family \n"+persons;
	}	
}