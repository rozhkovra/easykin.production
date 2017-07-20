package ru.rrozhkov.lib.convert;

public interface IConverter<T,E> {
	E convert(T entry);
}