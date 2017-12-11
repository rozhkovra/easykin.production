package ru.rrozhkov.easykin.model.task.util;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.easykin.model.task.impl.TaskFactory;
import ru.rrozhkov.lib.util.DateUtil;

public class TaskUtil {
	public static boolean withPayment(ITask task){
		String text = task.getName();
		int index = text.indexOf('$');
		int lastIndex = text.lastIndexOf('$');
		return index!=-1 && lastIndex!=-1 && index!=lastIndex;
	}
	
	public static Money extractAmount(ITask task){
		if(withPayment(task)){
			String text = task.getName();
			int index = text.indexOf('$');
			int lastIndex = text.lastIndexOf('$');
			String value = text.substring(index+1, lastIndex);
			return Money.valueOf(value);
		}
		return null;
	}
	public static String extractComment(ITask task){
		if(withPayment(task)){
			String text = task.getName();
			int index = text.indexOf('$');
			return text.substring(0, index);
		}
		return task.getName();
	}

	public static void main(String[] args){
		System.out.println(extractComment(TaskFactory.createTask(0,"123 $100$", DateUtil.today(),DateUtil.today(),0,0,"",DateUtil.today(),1)));
		System.out.println(extractComment(TaskFactory.createTask(0,"12", DateUtil.today(),DateUtil.today(),0,0,"",DateUtil.today(),1)));
	}
}
