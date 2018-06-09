package ru.rrozhkov.easykin.core.data.impl;

import java.util.Collection;

import ru.rrozhkov.easykin.core.data.ICollectionDataProvider;

public class CollectionDataProvider<T> implements ICollectionDataProvider<T> {
	protected Collection<T> collection; 
	
	public CollectionDataProvider(Collection<T> collection){
		this.collection = collection;
	}
	
	public Collection<T> getData() {		
		return collection;
	}
}