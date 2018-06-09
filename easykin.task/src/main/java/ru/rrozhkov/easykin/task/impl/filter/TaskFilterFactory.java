package ru.rrozhkov.easykin.task.impl.filter;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.easykin.core.filter.IFilter;

import java.util.Date;

public class TaskFilterFactory {
	public static class TaskFilterFactoryHolder {
		public static final TaskFilterFactory INSTANCE = new TaskFilterFactory();
	}

	public static TaskFilterFactory instance(){
		return TaskFilterFactoryHolder.INSTANCE;
	}

	public IFilter<ITask> home(){
		return new OnlyHomeFilter();
	}
	public IFilter<ITask> work(){
		return new OnlyWorkFilter();
	}
	public IFilter<ITask> status(Status status){
		return new StatusFilter(status);
	}
	public IFilter<ITask> category(ICategory category){
		return new CategoryFilter(category);
	}
	public IFilter<ITask> priority(Priority priority){
		return new PriorityFilter(priority);
	}
	public IFilter<ITask> withPayment(){
		return new WithPaymentFilter();
	}
	public IFilter<ITask> fromDate(Date date){
		return new FromDateFilter(date);
	}
	public IFilter<ITask> toDate(Date date){
		return new ToDateFilter(date);
	}
	public TaskFilterBean bean(int statusId, int categoryId, int priorityId, Date fromDate, Date todate, int personId) {
		return new TaskFilterBean(statusId, categoryId, priorityId, fromDate, todate, personId);
	}
}
