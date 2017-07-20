package ru.rrozhkov.easykin.gui.style.impl.custom;

import ru.rrozhkov.easykin.gui.style.impl.CollectionConverter;
import ru.rrozhkov.easykin.model.task.IComment;
import ru.rrozhkov.lib.util.DateUtil;

public class CommentConverter extends CollectionConverter<IComment> {
	public CommentConverter(int colSize) {
		super(colSize);
	}

	public String[] convert(int i, IComment entry) {
		return new String[]{String.valueOf(i), entry.getText(), DateUtil.format(entry.getDate())};
	}
}