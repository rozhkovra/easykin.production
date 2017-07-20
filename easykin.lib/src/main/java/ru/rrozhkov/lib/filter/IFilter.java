package ru.rrozhkov.lib.filter;

public interface IFilter<T> {
	boolean filter(T obj);
}