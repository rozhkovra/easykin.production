package ru.rrozhkov.lib.data;

import java.util.Collection;

public interface ICollectionDataProvider<T> {
	Collection<T> getData();
}