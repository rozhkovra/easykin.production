package ru.rrozhkov.easykin.model.auto;

import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.person.IPerson;

public interface IRegisteredCar extends ICar {
	IPerson getOwner();
	IDoc getTechPassport();
}