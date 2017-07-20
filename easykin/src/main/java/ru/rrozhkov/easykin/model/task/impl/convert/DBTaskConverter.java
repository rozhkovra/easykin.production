package ru.rrozhkov.easykin.model.task.impl.convert;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.ITaskConverter;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;

public class DBTaskConverter implements ITaskConverter<ResultSet> {

	public ITask convert(ResultSet result){
		try{
			return TaskFactory.createTask(result.getInt("id"), result.getString("name"), result.getDate("createdate")
					, result.getDate("plandate"), result.getInt("priorityid"), result.getInt("categoryid")
					, result.getString("categoryname"), result.getDate("closedate"), result.getInt("statusid"));
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}