package ru.rrozhkov.easykin.task.comment.impl.filter;

import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.core.filter.IFilter;

public class CommentFilterFactory {
	public static class CommentFilterFactoryHolder {
		public static final CommentFilterFactory INSTANCE = new CommentFilterFactory();
	}

	public static CommentFilterFactory instance(){
		return CommentFilterFactoryHolder.INSTANCE;
	}

	public IFilter<IComment> task(int taskId){
		return new TaskFilter(taskId);
	}
}
