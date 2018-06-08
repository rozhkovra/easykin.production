package ru.rrozhkov.easykin.family.db.impl;

import ru.rrozhkov.easykin.family.impl.convert.DBKinPersonConverter;
import ru.rrozhkov.easykin.person.db.impl.PersonHandler;
import ru.rrozhkov.lib.convert.IEntityConverter;

public class KinPersonHandler extends PersonHandler {
	public static class KinPersonHandlerHolder {
		public static final KinPersonHandler INSTANCE = new KinPersonHandler();
	}

	public static KinPersonHandler instance(){
		return KinPersonHandlerHolder.INSTANCE;
	}

	@Override
	protected String getSelect() {
		return "select * from "+getTableName()+" inner join KINPERSON on "+getTableName()+".id = KINPERSON.person";
	}

	@Override
	protected IEntityConverter getConverter() {
		return new DBKinPersonConverter();
	}
}
