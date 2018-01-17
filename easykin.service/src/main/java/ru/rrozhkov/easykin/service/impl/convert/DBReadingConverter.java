package ru.rrozhkov.easykin.service.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IReading;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBReadingConverter implements IConverter<ResultSet, IReading> {

	public IReading convert(ResultSet result){
		try{
			return new ServiceFactory().createReading(result.getInt("id"), result.getDate("reddate"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}