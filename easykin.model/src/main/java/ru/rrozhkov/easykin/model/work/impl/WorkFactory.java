package ru.rrozhkov.easykin.model.work.impl;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.model.person.Sex;
import ru.rrozhkov.easykin.model.person.impl.PersonFactory;
import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.easykin.model.work.ReleaseType;
import ru.rrozhkov.easykin.model.work.TaskType;
import ru.rrozhkov.easykin.core.util.DateUtil;

import java.util.Date;


public class WorkFactory {
	final static private PersonFactory personFactory = new PersonFactory();

	public static class WorkFactoryHolder {
		public static final WorkFactory INSTANCE = new WorkFactory();
	}

	public static WorkFactory instance(){
		return WorkFactoryHolder.INSTANCE;
	}

	public IActivity create(int id, Date date, IPerson person,
			int time, TaskType taskType, String name, ReleaseType releaseType, String desc) {
		return new Activity(id, date, person, time, taskType, name, releaseType, desc);
	}

	public IActivity newActivity(){
		return create(-1, new Date(), personFactory.create(1,"Рожков","Роман","Александрович", DateUtil.parse("29.08.1985"), Sex.MALE), 0, TaskType.ANOTHER
				, "", ReleaseType.ANOTHER, "");
	}
}