package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.convert.IEntityConverter;
import ru.rrozhkov.lib.db.IDBManager;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

public class CategoryHandler {
	final private static IDBManager dbManager = DBManager.instance();
	final private static TaskConverterFactory taskConverterFactory = new TaskConverterFactory();
	final private static IEntityConverter converter = taskConverterFactory.category();

	public static String select = "SELECT * FROM category ORDER BY ID";
	
	public static Collection<ICategory> select() throws Exception{
		return dbManager.select(select, converter);
	}
}