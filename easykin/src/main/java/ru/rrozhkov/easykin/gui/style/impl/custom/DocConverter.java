package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.doc.IDoc;

public class DocConverter extends CollectionConverter<IDoc> {
	public DocConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IDoc entry) {
		return new String[]{String.valueOf(i), entry.getPerson().toString(), entry.getDocType().toString()};
	}
}