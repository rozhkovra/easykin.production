package ru.rrozhkov.easykin.work.gui.style.impl.custom;

import ru.rrozhkov.easykin.model.person.util.PersonUtil;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.style.impl.CollectionConverter;
import ru.rrozhkov.lib.util.DateUtil;

import java.util.LinkedList;
import java.util.List;

public class ActivityConverter extends CollectionConverter<IActivity>{
	public ActivityConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IActivity t){
		List<String> list = new LinkedList<String>();
		list.add(String.valueOf(i));
		list.add(PersonUtil.fi(t.getPerson()));
		list.add(DateUtil.format(t.getDate()));
		list.add(String.valueOf(t.getTime()));
		list.add(t.getTaskType().toString());
		list.add(t.getName());
		list.add(t.getReleaseType().toString());
		list.add(t.getDesc());
		return list.toArray(new String[list.size()]);
	}
}