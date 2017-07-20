package ru.rrozhkov.easykin.gui.style.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.gui.style.ICollectionConverter;
import ru.rrozhkov.lib.collection.CollectionUtil;

public abstract class CollectionConverter<E> implements ICollectionConverter<E>{
	private int colSize;
	public CollectionConverter(int colSize){
		this.colSize = colSize;
	}
	public String[][] convert(Collection<E> collection){
		Collection<String[]> list = CollectionUtil.<String[]>create();
		for(E entry : collection){
			list.add(convert(list.size()+1,entry));
		}
		return list.toArray(new String[list.size()][colSize]);
	}
	
	public abstract String[] convert(int i, E entry);
}
