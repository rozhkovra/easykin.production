package ru.rrozhkov.easykin.model.doc;

import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;
import java.util.Date;

public interface IDoc {
	DocType getDocType();
	IPerson getPerson();
	String getNumber();
	String getSeries();
	File getScan();
	Date getDate();
}