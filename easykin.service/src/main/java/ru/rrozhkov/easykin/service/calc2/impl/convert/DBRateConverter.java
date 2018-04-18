package ru.rrozhkov.easykin.service.calc2.impl.convert;

import ru.rrozhkov.easykin.model.service.calc2.IRate;
import ru.rrozhkov.easykin.model.service.calc2.RateType;
import ru.rrozhkov.easykin.model.service.calc2.impl.ServiceFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBRateConverter implements IConverter<ResultSet, IRate> {

	public IRate convert(ResultSet result){
		try{
			return ServiceFactory.createRate(result.getInt("id"), RateType.type(result.getString("rateType"))
					, result.getString("rateValue"), result.getDate("dateFrom"),result.getDate("dateTo"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}