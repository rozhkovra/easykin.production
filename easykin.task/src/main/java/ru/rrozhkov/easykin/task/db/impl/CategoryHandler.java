package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.easykin.core.convert.IEntityConverter;
import ru.rrozhkov.easykin.core.db.impl.EntityHandler;

public class CategoryHandler extends EntityHandler {
	final private static TaskConverterFactory taskConverterFactory = TaskConverterFactory.instance();

	private static class CategoryHandlerHolder {
		private static final CategoryHandler INSTANCE = new CategoryHandler();
	}

	private CategoryHandler() {
	}

	protected static CategoryHandler instance(){
		return CategoryHandlerHolder.INSTANCE;
	}

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
}