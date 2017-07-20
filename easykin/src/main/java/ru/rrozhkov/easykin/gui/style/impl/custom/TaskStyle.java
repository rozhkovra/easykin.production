package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.lib.gui.style.ICollectionConverter;
import ru.rrozhkov.lib.gui.style.IStyle;
import ru.rrozhkov.lib.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.task.ITask;

public class TaskStyle implements IStyle<ITask> {

	public ITableStyle<ITask> tableStyle() {
		return new TaskTableStyle();
	}

	public ICollectionConverter<ITask> dataConverter() {
		return new TaskConverter(tableStyle().getColumnCount());
	}
}