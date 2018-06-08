package ru.rrozhkov.easykin.person.db.impl;

import ru.rrozhkov.easykin.person.impl.convert.PersonConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

public class PersonHandler extends EntityHandler {
	private static final PersonConverterFactory converterFactory = PersonConverterFactory.instance();

	public static class PersonHandlerHolder {
		public static final PersonHandler INSTANCE = new PersonHandler();
	}

	public static PersonHandler instance(){
		return PersonHandlerHolder.INSTANCE;
	}

	@Override
	protected String getTableName() {
		return "PERSON";
	}

	@Override
	protected IEntityConverter getConverter() {
		return converterFactory.person();
	}
}