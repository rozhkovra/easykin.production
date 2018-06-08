package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

public class PersonHandler extends EntityHandler {
	private static final PersonConverterFactory converterFactory = new PersonConverterFactory();

	@Override
	protected String getTableName() {
		return "PERSON";
	}

	@Override
	protected IEntityConverter getConverter() {
		return converterFactory.person();
	}

	@Override
	protected String getSelect() {
		return "select * from "+getTableName();
	}

	@Override
	protected String getInsert() {
		return null;
	}

	@Override
	protected String getUpdate() {
		return null;
	}
}