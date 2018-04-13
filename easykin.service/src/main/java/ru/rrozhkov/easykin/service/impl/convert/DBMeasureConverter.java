package ru.rrozhkov.easykin.service.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IMeasure;
import ru.rrozhkov.easykin.model.service.calc2.MeasureType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMeasureConverter implements IConverter<ResultSet, IMeasure> {

	public IMeasure convert(ResultSet result){
		try{
			return ServiceFactory.createMeasure(result.getInt("id"), result.getInt("readingid"), MeasureType.type(result.getString("measuretype")), Integer.valueOf(result.getString("MEASUREVALUE")));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}