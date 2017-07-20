package ru.rrozhkov.easykin.model.task.util;

import ru.rrozhkov.easykin.model.fin.Money;
import ru.rrozhkov.easykin.model.fin.MoneyFactory;
import ru.rrozhkov.easykin.model.task.ITask;

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
			return MoneyFactory.create(Double.valueOf(value));
		}
		return null;
	}
}
