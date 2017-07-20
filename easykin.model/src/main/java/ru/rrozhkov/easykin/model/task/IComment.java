package ru.rrozhkov.easykin.model.task;

import java.util.Date;

public interface IComment {
	int getId();
	String getText();
	Date getDate();
	int getTaskId();
}