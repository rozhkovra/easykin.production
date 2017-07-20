package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.auto.service.IService;
import ru.rrozhkov.lib.util.DateUtil;

public class ServiceConverter extends CollectionConverter<IService> {
	public ServiceConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IService entry) {
		return new String[]{String.valueOf(i), entry.getName(), entry.getPrice().toString(), DateUtil.format(entry.getDate())};
	}
}