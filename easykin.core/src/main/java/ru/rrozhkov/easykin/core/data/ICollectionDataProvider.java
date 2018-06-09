package ru.rrozhkov.easykin.core.data;

import java.util.Collection;

public interface ICollectionDataProvider<T> {
	Collection<T> getData();
}