package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.auto.service.IService;

public class ServiceStyle implements IStyle<IService> {

	public ITableStyle<IService> tableStyle() {
		return new ServiceTableStyle();
	}

	public ICollectionConverter<IService> dataConverter() {
		return new ServiceConverter(tableStyle().getColumnCount());
	}

}
