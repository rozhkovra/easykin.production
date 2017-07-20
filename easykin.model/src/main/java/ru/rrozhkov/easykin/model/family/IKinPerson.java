package ru.rrozhkov.easykin.model.family;

import ru.rrozhkov.easykin.model.person.IPerson;

public interface IKinPerson extends IPerson{
	KinType getKinType();
}