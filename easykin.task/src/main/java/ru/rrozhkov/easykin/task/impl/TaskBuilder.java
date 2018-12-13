package ru.rrozhkov.easykin.task.impl;

import ru.rrozhkov.easykin.core.filter.util.FilterUtil;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.task.comment.impl.filter.CommentFilterFactory;

import java.util.Collection;

public class TaskBuilder {
	final private static CommentFilterFactory commentFilterFactory = CommentFilterFactory.instance();

	private static class Holder {
		private static final TaskBuilder INSTANCE = new TaskBuilder();
	}

	static TaskBuilder instance(){
		return Holder.INSTANCE;
	}

	private TaskBuilder() {
	}

	public ITask buildTask(final ITask task, final Collection<IComment> comments){
		try {
			task.comments().clear();
			task.comments().addAll(comments);
			return task;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Collection<ITask> build(final Collection<ITask> tasks, final Collection<IComment> comments) {
		for(ITask task : tasks){
			task.comments().clear();
			task.comments().addAll(FilterUtil.filter(comments,commentFilterFactory.task(task.getId())));
		}
		return tasks;
	}
}
