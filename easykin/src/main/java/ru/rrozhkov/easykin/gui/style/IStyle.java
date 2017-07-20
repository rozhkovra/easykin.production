package ru.rrozhkov.easykin.gui.style;

public interface IStyle<T> {
	ITableStyle<T> tableStyle();
	ICollectionConverter<T> dataConverter();
}
