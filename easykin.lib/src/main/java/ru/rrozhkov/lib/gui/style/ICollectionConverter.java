package ru.rrozhkov.lib.gui.style;

import java.util.Collection;

import ru.rrozhkov.lib.convert.IConverter;

public interface ICollectionConverter<E> extends IConverter<Collection<E>,String[][]>{
	String[][] convert(Collection<E> collection);
}