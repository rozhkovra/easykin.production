package ru.rrozhkov.easykin.work.impl.convert;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;
import ru.rrozhkov.easykin.model.work.impl.WorkFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;

public class DBActivityConverter implements IConverter<ResultSet, IActivity> {

	public IActivity convert(ResultSet entry) {
		try{
			return WorkFactory.create(entry.getInt("id"), entry.getDate("actdate")
					, null, entry.getInt("acttime")
					, TaskType.type(entry.getString("tasktype")), entry.getString("name")
					, ReleaseType.type(entry.getString("releaseType")), entry.getString("desc"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}