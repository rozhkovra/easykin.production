package ru.rrozhkov.easykin.core.collection;

import java.util.*;

public class CollectionUtil {
	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(Collection collection){
		return collection==null || collection.isEmpty();		
	}
	
	public static <T> Collection<T> copy(Collection<T> collection){
		Collection<T> newCollection = list();
		newCollection.addAll(collection);
		return newCollection;
	}

	public static <T> Collection<T> merge2copy(Collection<T> collection, T obj){
		Collection<T> newCollection = list();
		newCollection.addAll(collection);
		newCollection.add(obj);
		return newCollection;
	}

	public static <T> Collection<T> create(){
		return list();
	}

	public static <T> Collection<T> list(){
		return new LinkedList<T>();
	}

	public static <T,E> Map<T,E> map(){
		return new HashMap<T,E>();
	}

	public static <T> T get(Collection<T> collectoin, int index){
		if(index > collectoin.size()-1 || index < 0)
			return null;
		return ((List<T>)collectoin).get(index);

	}
	public static <T> Collection<T> create(T... objects){
		Collection<T> newCollection = list();
		for(T obj : objects){
			newCollection.add(obj);
		}
		return newCollection;
	}

}