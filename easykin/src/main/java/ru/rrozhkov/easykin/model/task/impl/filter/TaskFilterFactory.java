package ru.rrozhkov.easykin.model.task.impl.filter;

import ru.rrozhkov.easykin.model.category.ICategory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.Priority;
import ru.rrozhkov.easykin.model.task.Status;
import ru.rrozhkov.lib.filter.IFilter;

public class TaskFilterFactory {
	public static IFilter<ITask> home(){
		return new OnlyHomeFilter();
	}
	public static IFilter<ITask> work(){
		return new OnlyWorkFilter();
	}
	public static IFilter<ITask> status(Status status){
		return new StatusFilter(status);
	}
	public static IFilter<ITask> category(ICategory category){
		return new CategoryFilter(category);
	}
	public static IFilter<ITask> priority(Priority priority){
		return new PriorityFilter(priority);
	}
	public static IFilter<ITask> withPayment(){
		return new WithPaymentFilter();
	}
}
