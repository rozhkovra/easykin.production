package ru.rrozhkov.easykin.model.task.comment.impl.filter;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.lib.filter.IFilter;

public class CommentFilterFactory {
	public static IFilter<IComment> createTaskFilter(int taskId){
		return new TaskFilter(taskId);
	}
}
