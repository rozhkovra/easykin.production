package ru.rrozhkov.easykin.core.convert;

public interface IConverter<T,E> {
	E convert(T entry);
}