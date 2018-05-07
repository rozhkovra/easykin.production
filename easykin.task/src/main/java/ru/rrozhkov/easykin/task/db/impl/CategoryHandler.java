package ru.rrozhkov.easykin.task.db.impl;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.task.impl.convert.TaskConverterFactory;
import ru.rrozhkov.lib.db.impl.DBManager;

import java.util.Collection;

public class CategoryHandler {
	public static String select = "SELECT * FROM category ORDER BY ID";
	
	public static Collection<ICategory> select() throws Exception{
		return DBManager.instance().select(select, TaskConverterFactory.category());
	}
}