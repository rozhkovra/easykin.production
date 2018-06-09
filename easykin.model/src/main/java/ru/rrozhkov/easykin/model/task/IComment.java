package ru.rrozhkov.easykin.model.task;

import ru.rrozhkov.easykin.core.db.IEntity;

import java.util.Date;

public interface IComment extends IEntity{
	int getId();
	String getText();
	Date getDate();
	int getTaskId();
}