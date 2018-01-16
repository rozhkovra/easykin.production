package ru.rrozhkov.easykin.work.gui.style.impl.custom;

import ru.rrozhkov.easykin.model.work.IActivity;
import ru.rrozhkov.lib.gui.style.ICollectionConverter;
import ru.rrozhkov.lib.gui.style.IStyle;
import ru.rrozhkov.lib.gui.style.ITableStyle;

public class ActivityStyle implements IStyle<IActivity> {

	public ITableStyle<IActivity> tableStyle() {
		return new ActivityTableStyle();
	}

	public ICollectionConverter<IActivity> dataConverter() {
		return new ActivityConverter(tableStyle().getColumnCount());
	}
}