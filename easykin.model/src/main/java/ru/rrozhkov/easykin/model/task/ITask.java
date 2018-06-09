package ru.rrozhkov.easykin.model.task;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.core.db.IEntity;

import java.util.Collection;
import java.util.Date;

public interface ITask extends IEntity {
	int getId();
	String getName();
	Date getCreateDate();
	Date getPlanDate();
	Priority getPriority();
	ICategory getCategory();
	Date getCloseDate();
	Status getStatus();
	Collection<IComment> comments();
}