package ru.rrozhkov.easykin.model.task.impl.convert;

import java.sql.ResultSet;
import java.sql.SQLException;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.lib.convert.IConverter;

public class DBCommentConverter implements IConverter<ResultSet, IComment> {

	public IComment convert(ResultSet result){
		try{
			return TaskFactory.createComment(result.getInt("id"), result.getString("text")
					, result.getDate("createdate"), result.getInt("taskId")
					);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}