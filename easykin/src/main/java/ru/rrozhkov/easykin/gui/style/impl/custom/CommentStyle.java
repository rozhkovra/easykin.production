package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.easykin.gui.style.IStyle;
import ru.rrozhkov.easykin.gui.style.ITableStyle;
import ru.rrozhkov.easykin.model.task.IComment;

public class CommentStyle implements IStyle<IComment> {

	public ITableStyle<IComment> tableStyle() {
		return new CommentTableStyle();
	}

	public ICollectionConverter<IComment> dataConverter() {
		return new CommentConverter(tableStyle().getColumnCount());
	}
}
