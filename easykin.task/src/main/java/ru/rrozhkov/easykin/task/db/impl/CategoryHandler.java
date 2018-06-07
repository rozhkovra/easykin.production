package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.impl.EntityHandler;

public class CategoryHandler extends EntityHandler {
	final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();

	@Override
	protected String getTableName() {
		return "category";
	}

	@Override
	protected IEntityConverter getConverter() {
		return taskConverterFactory.category();
	}

	@Override
	protected String getSelect() {
		return "SELECT * FROM "+getTableName()+" ORDER BY ID";
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