package ru.rrozhkov.easykin.model.task.impl;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.collection.CollectionUtil;

import java.util.Collection;
import java.util.Date;

public class Task implements ITask, Comparable<ITask>{
	
	protected String name;
	protected Date createDate;
	protected Date planDate;
	protected Priority priority;
	protected ICategory category;
	protected Date closeDate;
	protected Status status;
	private int id;
	private Collection<IComment> comments;
	
	public Task(int id, String name, Date createDate, Date plannedDate,
			Priority priority, ICategory category, Date closeDate, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.createDate = createDate;
		this.planDate = plannedDate;
		this.priority = priority;
		this.category = category;
		this.closeDate = closeDate;
		this.status = status;
		this.comments = CollectionUtil.<IComment>create();
	}

	
	public String getName() {
		return name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getPlanDate() {
		return planDate;
	}

	public Priority getPriority() {
		return priority;
	}

	public ICategory getCategory() {
		return category;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public Status getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	public int compareTo(ITask o) {
		int val = 0;
		if(val==0)
			val = (int) (getPlanDate().getTime()-o.getPlanDate().getTime());
		if(val==0)
			val = getName().compareTo(o.getName());
		return val;
	}

	public Collection<IComment> comments() {
		return comments;
	}

	@Override
	public boolean equals(Object obj) {
		Task task = (Task)obj;
		return id==task.getId()
				&& name.equals(task.getName())
				&& priority.equals(task.getPriority())
				&& category.equals(task.getCategory())
				&& status.equals(task.getStatus());
	}
}