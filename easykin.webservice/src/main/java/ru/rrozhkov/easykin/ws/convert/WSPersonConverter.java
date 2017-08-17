package ru.rrozhkov.easykin.ws.convert;

import ru.rrozhkov.easykin.model.person.IPerson;
import ru.rrozhkov.easykin.ws.bean.PersonBean;
import ru.rrozhkov.lib.convert.IConverter;

public class WSPersonConverter implements IConverter<IPerson, PersonBean> {

	public PersonBean convert(IPerson person) {
		PersonBean bean = new PersonBean();
		bean.setId(person.getId());
		bean.setSurname(person.getSurname());
		bean.setName(person.getName());
		bean.setSecondName(person.getSecondName());
		bean.setBirthDate(person.getBirthDate());
		bean.setSex(person.getSex());
		bean.setUsername(person.getUsername());
		bean.setPassword(person.getPassword());
		return bean;
	}
	
}
