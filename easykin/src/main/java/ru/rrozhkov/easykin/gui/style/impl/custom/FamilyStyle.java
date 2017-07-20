package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.person.IPerson;

public class FamilyStyle implements IStyle<IPerson> {

	public ITableStyle<IPerson> tableStyle() {
		return new FamilyTableStyle();
	}

	public ICollectionConverter<IPerson> dataConverter() {
		return new FamilyConverter(tableStyle().getColumnCount());
	}

}