package ru.rrozhkov.easykin.model.category;

public class Category implements ICategory{
	protected int id;
	protected String name;       

    public Category (int id, String name) {
        this.id = id;
    	this.name = name;
    }
    
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
        return this.name;
    }

	public boolean isHome() {
		return id==1;
	}

	public boolean isWork() {
		return id==8;
	}
}