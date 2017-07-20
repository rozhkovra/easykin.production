package ru.rrozhkov.easykin.model.task.impl.convert;

import ru.rrozhkov.easykin.model.task.ITask2Person;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.lib.convert.IConverter;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTask2PersonConverter implements IConverter<ResultSet, ITask2Person> {

	public ITask2Person convert(ResultSet result){
		try{
			return TaskFactory.createT2P(result.getInt("id"), result.getInt("person"), result.getInt("task"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}