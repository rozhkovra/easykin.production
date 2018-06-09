package ru.rrozhkov.easykin.core.gui.style;

import java.util.Collection;

import ru.rrozhkov.easykin.core.convert.IConverter;

public interface ICollectionConverter<E> extends IConverter<Collection<E>,String[][]>{
	String[][] convert(Collection<E> collection);
}