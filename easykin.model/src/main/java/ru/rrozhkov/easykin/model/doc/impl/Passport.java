package ru.rrozhkov.easykin.model.doc.impl;

import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;
import java.util.Date;

import static ru.rrozhkov.easykin.model.doc.DocType.PASSPORT;

public class Passport extends Doc {
	private String number;
	private String series;
	private String org;
	private Date issueDate;
	
	public Passport( IPerson person, String number,
			String series, String org, Date issueDate, File scan) {
		super(PASSPORT, person, scan);
		this.number = number;
		this.series = series;
		this.org = org;
		this.issueDate = issueDate;
	}

	public String getNumber() {
		return number;
	}

	public String getSeries() {
		return series;
	}

	public Date getDate() {
		return issueDate;
	}

	public String getOrg() {
		return org;
	}

	public Date getIssueDate() {
		return issueDate;
	}	
}