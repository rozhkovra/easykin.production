package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.lib.util.DateUtil;


public class FamilyConverter extends CollectionConverter<IPerson> {
	public FamilyConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IPerson entry) {
		return new String[]{String.valueOf(i), entry.getSurname(), entry.getName(), entry.getSecondName(), DateUtil.format(entry.getBirthDate())};
	}
}