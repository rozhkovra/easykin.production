package ru.rrozhkov.easykin.core.filter;

public interface IFilter<T> {
	boolean filter(T obj);
}