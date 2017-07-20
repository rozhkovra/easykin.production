package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.doc.IDoc;

public class DocStyle implements IStyle<IDoc> {

	public ITableStyle<IDoc> tableStyle() {
		return new DocTableStyle();
	}

	public ICollectionConverter<IDoc> dataConverter() {
		return new DocConverter(tableStyle().getColumnCount());
	}

}