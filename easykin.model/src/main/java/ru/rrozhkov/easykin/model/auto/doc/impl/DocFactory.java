package ru.rrozhkov.easykin.model.auto.doc.impl;

import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;
import java.util.Date;

public class DocFactory {
	public static IDoc createTechPassport(IPerson person, String number, String series,
			String org, Date issueDate, File scan, String regNumber, String specComment) {
		return new TechPassport(person, number, series, org, issueDate, scan, regNumber, specComment);
	}
}