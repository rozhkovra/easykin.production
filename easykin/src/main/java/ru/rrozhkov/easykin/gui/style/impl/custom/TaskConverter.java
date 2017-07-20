package ru.rrozhkov.easykin.gui.style.impl.custom;

import java.util.LinkedList;
import java.util.List;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.task.ITask;
import ru.rrozhkov.lib.util.DateUtil;

public class TaskConverter extends CollectionConverter<ITask>{
	public TaskConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, ITask t){
		List<String> list = new LinkedList<String>();
		list.add(String.valueOf(i));
		list.add(t.getName());
		list.add(DateUtil.format(t.getPlanDate()));
		list.add(t.getPriority().toString());
		list.add(t.getCategory().getName());
		if(t.getStatus().isOpen()){
			list.add(DateUtil.format(t.getCreateDate()));
		}else
			list.add(DateUtil.format(t.getCloseDate()));
		return list.toArray(new String[list.size()]);
	}
}