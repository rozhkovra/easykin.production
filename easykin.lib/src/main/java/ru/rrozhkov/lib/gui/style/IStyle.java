package ru.rrozhkov.lib.gui.style;

public interface IStyle<T> {
	ITableStyle<T> tableStyle();
	ICollectionConverter<T> dataConverter();
}
