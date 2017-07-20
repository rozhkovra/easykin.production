package ru.rrozhkov.easykin.db.impl;

import java.sql.SQLException;
import java.util.Collection;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.category.convert.DBCategoryConverter;

public class CategoryHandler {
	public static String select = "SELECT * FROM category ORDER BY ID";
	
	public static Collection<ICategory> select() throws SQLException{
		return EasyKinDBManager.instance().select(select, new DBCategoryConverter());
	}
}