package ru.rrozhkov.easykin.model.doc.impl;

import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;
import java.util.Date;

import static ru.rrozhkov.easykin.model.doc.DocType.SNILS;

public class SNILS extends Doc {
	private String number;

	public SNILS(IPerson person, String number, File scan) {
		super(SNILS, person, scan);
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public String getSeries() {
		return "";
	}

	public Date getDate() {
		return new Date();
	}
}