package ru.rrozhkov.easykin.model.category;

public class CategoryFactory {
	public static ICategory create(int id, String name){
		return new Category(id, name);
	}
}