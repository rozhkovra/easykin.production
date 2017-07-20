package ru.rrozhkov.easykin.model.doc.impl;

import ru.rrozhkov.easykin.model.doc.DocType;
import ru.rrozhkov.easykin.model.doc.IDoc;
import ru.rrozhkov.easykin.model.person.IPerson;

import java.io.File;

public abstract class Doc implements IDoc {
	protected DocType docType;
	private IPerson person;
	private File scan;

	public Doc(DocType docType, IPerson person, File scan) {
		this.docType = docType;
		this.person = person;
		this.scan = scan;
	}

	public DocType getDocType() {
		return docType;
	}

	public IPerson getPerson() {
		return person;
	}

	public File getScan() {
		return scan;
	}	
}