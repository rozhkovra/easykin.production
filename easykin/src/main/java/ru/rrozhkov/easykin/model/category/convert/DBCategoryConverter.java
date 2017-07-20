package ru.rrozhkov.easykin.model.category.convert;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rrozhkov.easykin.model.category.CategoryFactory;
import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.lib.convert.IConverter;

public class DBCategoryConverter implements IConverter<ResultSet, ICategory> {

	public ICategory convert(ResultSet result){
		try{
			return CategoryFactory.create(result.getInt("id"), result.getString("name"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}